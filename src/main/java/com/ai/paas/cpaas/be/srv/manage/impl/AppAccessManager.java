package com.ai.paas.cpaas.be.srv.manage.impl;

import com.ai.paas.cpaas.be.srv.interfaces.IAppAccessManager;
import com.ai.paas.cpaas.be.srv.manage.model.AppAccess;
import com.google.gson.Gson;

public class AppAccessManager implements IAppAccessManager {

	@Override
	public String add(String param) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		AppAccess appAccess = gson.fromJson(param, AppAccess.class);
		return null;
	}

	@Override
	public String modify(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String query(String param) {
		// TODO Auto-generated method stub
		return null;
	}

}
