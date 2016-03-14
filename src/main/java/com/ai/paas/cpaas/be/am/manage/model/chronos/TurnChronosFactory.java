package com.ai.paas.cpaas.be.am.manage.model.chronos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.ai.paas.cpaas.be.am.manage.RequestParamException;
import com.ai.paas.cpaas.be.am.manage.model.GeneralTimerReq;
import com.ai.paas.cpaas.be.am.manage.model.TimerQueryResp;

public class TurnChronosFactory {

	public static ChronosJob turnCreateReq(GeneralTimerReq generalTimerReq) throws RequestParamException {
		ChronosJob chronosJob = new ChronosJob();
		chronosJob.setName(generalTimerReq.getAppId());
		chronosJob.setRetries(generalTimerReq.getRetries());
		// chronosJob.setCommand(command);
		StringBuilder schedule = new StringBuilder("");
		schedule.append("R");
		if (StringUtils.isNotEmpty(generalTimerReq.getRepeatNum())) {
			schedule.append(generalTimerReq.getRepeatNum());
		}
		schedule.append("/");
		try {
			Date date = DateUtils.parseDate("20160223231500", "yyyyMMddHHmmss");
			schedule.append(DateFormatUtils.format(date, "yyyy-MM-dd'T'HH:mm:ss.s'Z'"));
		} catch (ParseException e) {
			throw new RequestParamException("param start can't be formated");
		}
		schedule.append("/P");
		schedule.append(generalTimerReq.getPeriod());
		chronosJob.setSchedule(schedule.toString());
		chronosJob.setCommand(generalTimerReq.getCommond());
		GeneralTimerReq.Container reqContainer = generalTimerReq.getContainer();
		if (reqContainer == null) {
			throw new RequestParamException("miss container info");
		}
		chronosJob.setCpus(reqContainer.getCpu());
		chronosJob.setMem(reqContainer.getMem());
		chronosJob.setDisk(reqContainer.getDisk());
		ChronosJob.Container container = new ChronosJob.Container();
		container.setImage(reqContainer.getImgFullName());
		// List<ChronosJob.Container.Volume> volumes = new ArrayList<>();
		// volumes.add(new ChronosJob.Container.Volume(reqContainer.getLogDir(),
		// reqContainer.getDataDir(), "RW"));
		// container.setVolumes(volumes);
		chronosJob.setContainer(container);
		if (CollectionUtils.isNotEmpty(reqContainer.getEnvVars())) {
			chronosJob.setEnvironmentVariables(reqContainer.getEnvVars());
		}

		List<List<String>> constraints = new ArrayList<>();
		if (StringUtils.isNotBlank(reqContainer.getZoneId())) {
			constraints.add(Arrays.asList("zoneId", "CLUSTER", reqContainer.getZoneId()));
		}
		if (StringUtils.isNotBlank(reqContainer.getAttrs())) {
			String[] kvs = reqContainer.getAttrs().split(";", -1);
			for (String kv : kvs) {
				String[] pair = kv.split(":", -1);
				constraints.add(Arrays.asList(pair[0], "CLUSTER", pair[1]));
			}
		}
		if (CollectionUtils.isNotEmpty(constraints))
			chronosJob.setConstraints(constraints);
		return chronosJob;
	}

	public static TimerQueryResp fillTimerQueryResp(TimerQueryResp timerQueryResp, JobsResp jobsResp) {
		for (ChronosJob job : jobsResp.getJobs()) {
			if (job.getName().equals(timerQueryResp.getAppId())) {
				timerQueryResp.setErrorCount(job.getErrorCount());
				timerQueryResp.setLastError(job.getLastError());
				timerQueryResp.setLastSuccess(job.getLastSuccess());
				timerQueryResp.setSchedule(job.getSchedule());
				timerQueryResp.setSuccessCount(job.getSuccessCount());
				break;
			}
		}
		return timerQueryResp;
	}

	public static void main(String[] args) throws ParseException {
		System.out.println(DateUtils.parseDate("20160223231500", "yyyyMMddHHmmss"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = sdf.parse("20160223231500");
		System.out.println(date);
		// sdf = new SimpleDateFormat("YYYY-MM-DDThh:mm:ss.sTZD");
		System.out.println(DateFormatUtils.format(date, "yyyy-MM-dd'T'HH:mm:ss.s'z'"));
		// System.out.println(sdf.format(date));
	}
}
