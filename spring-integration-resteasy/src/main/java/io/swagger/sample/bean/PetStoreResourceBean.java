package io.swagger.sample.bean;

import io.swagger.sample.data.StoreData;
import io.swagger.sample.model.Order;
import io.swagger.sample.exception.NotFoundException;
import io.swagger.sample.resource.PetStoreResource;

import javax.ws.rs.core.Response;

public class PetStoreResourceBean implements PetStoreResource {

	static StoreData storeData = new StoreData();

	@Override
	public Response getOrderById(Long orderId) throws NotFoundException {
		Order order = storeData.findOrderById(orderId);
		if (null != order) {
			return Response.ok().entity(order).build();
		} else {
			throw new NotFoundException(404, "Order not found");
		}
	}

	@Override
	public Response placeOrder(Order order) {
		storeData.placeOrder(order);
		return Response.ok().entity("").build();
	}

	@Override
	public Response deleteOrder(Long orderId) {
		if (storeData.deleteOrder(orderId)) {
			return Response.ok().entity("").build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("Order not found").build();
		}
	}
}
