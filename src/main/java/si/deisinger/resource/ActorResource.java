package si.deisinger.resource;


import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import si.deisinger.interceptor.RequestCounted;
import si.deisinger.model.Actor;
import si.deisinger.service.ActorService;

import java.util.List;

@Path("/actors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestCounted
public class ActorResource {

	@Inject
	ActorService actorService;

	@GET
	public List<Actor> getAllActors() {
		return actorService.getAllActors();
	}

	@GET
	@Path("/{id}")
	public Actor getActorById(@PathParam("id") Long id) {
		return actorService.getActorById(id);
	}

	@POST
	public Actor createActor(Actor actor) {
		return actorService.createActor(actor);
	}

	@PUT
	@Path("/{id}")
	public Actor updateActor(@PathParam("id") Long id, Actor updatedActor) {
		return actorService.updateActor(id, updatedActor);
	}

	@DELETE
	@Path("/{id}")
	public boolean deleteActor(@PathParam("id") Long id) {
		return actorService.deleteActor(id);
	}

	@GET
	@Path("/paginated")
	public List<Actor> getPaginatedActors(@QueryParam("page") int page, @QueryParam("pageSize") int pageSize) {
		return actorService.getPaginatedActors(page, pageSize);
	}

	@GET
	@Path("/search")
	public List<Actor> searchActors(@QueryParam("keyword") String keyword) {
		return actorService.searchActors(keyword);
	}

	// Endpoint to add Movies to Actors using Query
	@Transactional
	@POST
	@Path("/{id}")
	public Response addMovieToActor(@PathParam("id") Long id, @QueryParam("addMovie") int movieId) {
		Actor actor = Actor.findById(id);
		if (actor != null) {
			actor.addMovie(movieId);
			actor.persist();
			return Response.ok(actor).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

}
