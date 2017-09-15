package ca.cicccc.madp202.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("daily")
public class Daily {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/1day/{location}")
	public String get1day(@PathParam("location")String loc) {
		return "1day weather!"+loc;
	}
}
