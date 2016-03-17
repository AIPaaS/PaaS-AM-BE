package com.ai.paas.cpaas.be.srv.manage.impl;

import com.ai.paas.cpaas.be.srv.interfaces.IAppAccessManager;
import com.ai.paas.cpaas.be.srv.manage.model.AppAccess;
import com.ai.paas.cpaas.be.srv.service.MHService;
import com.ai.paas.cpaas.be.srv.vo.HaproxyResultVo;
import com.ai.paas.cpaas.be.srv.vo.TransResultVo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

public class AppAccessManager implements IAppAccessManager {

	@Autowired
	private MHService mHService;

	@Override
	public String add(String param) {

		Gson gson = new Gson();
		AppAccess appAccess = gson.fromJson(param, AppAccess.class);

		if (appAccess.getProtocol() != 1) return  errorJson("only accept http");
		if (null == appAccess.getAccessCode() || null != appAccess.getAccessCodeOld()) return errorJson("AccessCode is wrong");

		String result = mHService.addOrUpdateAcl(appAccess.getDns(),appAccess.getContainer(),appAccess.getAccessCode(),appAccess.getAccessCodeOld(),appAccess.getResCenterId());
		return result;
	}

	@Override
	public String modify(String param) {

		Gson gson = new Gson();
		AppAccess appAccess = gson.fromJson(param, AppAccess.class);

		if (appAccess.getProtocol() != 1) return  errorJson("only accept http");
		String result = mHService.addOrUpdateAcl(appAccess.getDns(),appAccess.getContainer(),appAccess.getAccessCode(),appAccess.getAccessCodeOld(),appAccess.getResCenterId());
		return result;
	}

	@Override
	public String delete(String param) {
		Gson gson = new Gson();
		AppAccess appAccess = gson.fromJson(param, AppAccess.class);

		if (appAccess.getProtocol() != 1) return  errorJson("only accept http");
		String result = mHService.delAcl(appAccess.getAccessCodeOld(),appAccess.getResCenterId());
		return result;
	}

	@Override
	public String query(String param) {

		Gson gson = new Gson();
		AppAccess appAccess = gson.fromJson(param, AppAccess.class);

		if (appAccess.getProtocol() != 1) return  errorJson("only accept http");
		String result = mHService.quryKeepAliveVIP(appAccess.getResCenterId());
		return result;
	}

	//错误信息
	public static String errorJson (String msg){

		HaproxyResultVo haproxyResultVo = new HaproxyResultVo();
		haproxyResultVo.setCode("1");
		haproxyResultVo.setMsg(msg);
		Gson gson = new Gson();
		return  gson.toJson(haproxyResultVo);
	}


}
