package io.swagger.sample.bean;

import io.swagger.sample.data.PetData;
import io.swagger.sample.model.Pet;
import io.swagger.sample.exception.NotFoundException;
import io.swagger.sample.resource.PetResource;

import javax.ws.rs.core.Response;

public class PetResourceBean implements PetResource {

	static PetData petData = new PetData();

	@Override
	public Pet getPetById(Long petId) throws NotFoundException {
		Pet pet = petData.getPetById(petId);
		if (null != pet) {
			return pet;
		} else {
			throw new NotFoundException(404, "Pet not found");
		}
	}

	@Override
	public Response addPet(Pet pet) {
		petData.addPet(pet);
		return Response.ok().entity("SUCCESS").build();
	}

	@Override
	public Response updatePet(Pet pet) {
		petData.addPet(pet);
		return Response.ok().entity("SUCCESS").build();
	}

	@Override
	public Response findPetsByStatus(String status) {
		return Response.ok(petData.findPetByStatus(status)).build();
	}

	@Override
	@Deprecated
	public Response findPetsByTags(String tags) {
		return Response.ok(petData.findPetByTags(tags)).build();
	}
}
