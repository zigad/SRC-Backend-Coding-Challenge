package si.deisinger.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import si.deisinger.interceptor.RequestCounted;
import si.deisinger.model.Movie;
import si.deisinger.service.MovieService;

import java.util.List;

@Path("/movies")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestCounted
public class MovieResource {

	@Inject
	MovieService movieService;

	@GET
	public List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}

	@GET
	@Path("/{id}")
	public Movie getMovieById(@PathParam("id") Long id) {
		return movieService.getMovieById(id);
	}

	@POST
	public Movie createMovie(Movie movie) {
		return movieService.createMovie(movie);
	}

	@PUT
	@Path("/{id}")
	public Movie updateMovie(@PathParam("id") Long id, Movie updatedMovie) {
		return movieService.updateMovie(id, updatedMovie);
	}

	@DELETE
	@Path("/{id}")
	public boolean deleteMovie(@PathParam("id") Long id) {
		return movieService.deleteMovie(id);
	}

	@GET
	@Path("/paginated")
	public List<Movie> getPaginatedMovies(@QueryParam("page") int page, @QueryParam("pageSize") int pageSize) {
		return movieService.getPaginatedMovies(page, pageSize);
	}

	@GET
	@Path("/search")
	public List<Movie> searchMovies(@QueryParam("keyword") String keyword) {
		return movieService.searchMovies(keyword);
	}

	// Endpoint to add actors to a movie using Query
	@Transactional
	@POST
	@Path("/{id}")
	public Response addActorsToMovie(@PathParam("id") Long id, @QueryParam("addActor") int actorId) {
		Movie movie = Movie.findById(id);
		if (movie != null) {
			movie.addActor(actorId);
			movie.persist();
			return Response.ok(movie).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

}