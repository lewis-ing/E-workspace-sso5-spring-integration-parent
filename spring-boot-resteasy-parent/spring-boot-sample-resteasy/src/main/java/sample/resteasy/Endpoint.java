package sample.resteasy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Path("/hello")
public class Endpoint {

	@Value("${message:World}")
	private String msg;

	@GET
	public String message() {
		return "Hello " + msg;
	}

}