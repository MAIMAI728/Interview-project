package ca.cicccc.madp202.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hourly")
public class Hourly {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/1hour/{location}")
	public String get1hour(@PathParam("location")String loc) {
		return "1hour weather!"+loc;
	}
}
