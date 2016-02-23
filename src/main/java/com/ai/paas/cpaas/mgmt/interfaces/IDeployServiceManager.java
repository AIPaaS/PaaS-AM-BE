package com.ai.paas.cpaas.mgmt.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/deploy/manage")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IDeployServiceManager {
	@Path("/create/longrun")
	@POST
	public String createLongRun(String param);

	@Path("/destroy/longrun")
	@POST
	public String destroyLongRun(String param);

	@Path("/create/timer")
	@POST
	public String createTimer(String param);

	@Path("/destroy/timer")
	@POST
	public String destroyTimer(String param);

	@Path("/start")
	@POST
	public String start(String param);

	@Path("/start/timer")
	@POST
	public String startTimer(String param);

	@Path("/stop")
	@POST
	public String stop(String param);

	@Path("/scale")
	@POST
	public String scale(String param);

	@Path("/upgrade")
	@POST
	public String upgrade(String param);

	@Path("/upgrade/timer")
	@POST
	public String upgradeTimer(String param);

	@Path("/log")
	@POST
	public String log(String param);

	@Path("/status")
	@POST
	public String status(String param);

	@Path("/status/timer")
	@POST
	public String statusTimer(String param);

	@Path("/callback")
	@POST
	public String testCallback(String param);
}
