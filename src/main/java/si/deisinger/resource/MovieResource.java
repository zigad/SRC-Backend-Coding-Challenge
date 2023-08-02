package si.deisinger.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
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
}