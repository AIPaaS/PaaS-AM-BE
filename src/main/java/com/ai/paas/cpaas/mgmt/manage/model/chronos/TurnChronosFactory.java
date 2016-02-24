package com.ai.paas.cpaas.mgmt.manage.model.chronos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.ai.paas.cpaas.mgmt.manage.model.GeneralTimerReq;
import com.ai.paas.cpaas.mgmt.manage.model.TimerQueryResp;

public class TurnChronosFactory {

	public static ChronosJob turnCreateReq(GeneralTimerReq generalTimerReq) {
		ChronosJob chronosJob = new ChronosJob();
		chronosJob.setRetries(generalTimerReq.getRetries());
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
			e.printStackTrace();
		}
		schedule.append("/P");
		schedule.append(generalTimerReq.getPeriod());
		chronosJob.setSchedule(schedule.toString());
		GeneralTimerReq.Container reqContainer = generalTimerReq.getContainer();
		if (reqContainer == null) {
			// throw exception;
		}
		chronosJob.setCpus(reqContainer.getCpu());
		chronosJob.setMem(reqContainer.getMem());
		return chronosJob;
	}

	public static TimerQueryResp fillTimerQueryResp(TimerQueryResp timerQueryResp, JobsResp jobsResp) {
		return null;
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
