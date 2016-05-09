package io.swagger.sample.bean;

import io.swagger.sample.data.UserData;
import io.swagger.sample.model.User;
import io.swagger.sample.exception.ApiException;
import io.swagger.sample.exception.NotFoundException;
import io.swagger.sample.resource.UserResource;

import javax.ws.rs.core.Response;

public class UserResourceBean implements UserResource {
	
	static UserData userData = new UserData();

	@Override
	public Response createUser(User user) {
		userData.addUser(user);
		return Response.ok().entity("").build();
	}

	@Override
	public Response createUsersWithArrayInput(User[] users) {
		for (User user : users) {
			userData.addUser(user);
		}
		return Response.ok().entity("").build();
	}

	@Override
	public Response createUsersWithListInput(java.util.List<User> users) {
		for (User user : users) {
			userData.addUser(user);
		}
		return Response.ok().entity("").build();
	}

	@Override
	public Response updateUser(String username, User user) {
		userData.addUser(user);
		return Response.ok().entity("").build();
	}

	@Override
	public Response deleteUser(String username) {
		if (userData.removeUser(username)) {
			return Response.ok().entity("").build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@Override
	public Response getUserByName(String username) throws ApiException {
		User user = userData.findUserByName(username);
		if (null != user) {
			return Response.ok().entity(user).build();
		} else {
			throw new NotFoundException(404, "User not found");
		}
	}

	@Override
	public Response loginUser(String username, String password) {
		return Response.ok().entity("logged in user session:" + System.currentTimeMillis()).build();
	}

	@Override
	public Response logoutUser() {
		return Response.ok().entity("").build();
	}
}