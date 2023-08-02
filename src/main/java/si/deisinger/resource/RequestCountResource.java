package si.deisinger.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import si.deisinger.interceptor.RequestCounted;
import si.deisinger.interceptor.RequestCounterInterceptor;

@Path("/requestcount")
@RequestCounted
public class RequestCountResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public int getRequestCount() {
		return RequestCounterInterceptor.getRequestCount();
	}
}
