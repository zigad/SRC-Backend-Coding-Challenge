package si.deisinger.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import si.deisinger.model.Movie;
import si.deisinger.repository.MovieRepository;

import java.util.List;

@ApplicationScoped
public class MovieService {

	@Inject
	MovieRepository movieRepository;

	@PersistenceContext
	EntityManager entityManager;

	public List<Movie> getAllMovies() {
		return movieRepository.listAll();
	}

	public Movie getMovieById(Long id) {
		return movieRepository.findById(id);
	}

	@Transactional
	public Movie createMovie(Movie movie) {
		movie.persist();
		return movie;
	}

	@Transactional
	public Movie updateMovie(Long id, Movie updatedMovie) {
		Movie movie = movieRepository.findById(id);
		if (movie != null) {
			movie.setTitle(updatedMovie.getTitle());
			movie.setYear(updatedMovie.getYear());
			movie.setDescription(updatedMovie.getDescription());
			movie.setPictures(updatedMovie.getPictures());
		}
		return movie;
	}

	@Transactional
	public boolean deleteMovie(Long id) {
		Movie movie = movieRepository.findById(id);
		if (movie != null) {
			movieRepository.delete(movie);
			return true;
		}
		return false;
	}

	public List<Movie> getPaginatedMovies(int page, int pageSize) {
		int offset = (page - 1) * pageSize;
		return entityManager
				.createQuery("SELECT m FROM Movie m", Movie.class)
				.setFirstResult(offset)
				.setMaxResults(pageSize)
				.getResultList();
	}

	public List<Movie> searchMovies(String keyword) {
		return entityManager
				.createQuery("SELECT m FROM Movie m WHERE m.title LIKE :keyword OR m.description LIKE :keyword", Movie.class)
				.setParameter("keyword", "%" + keyword + "%")
				.getResultList();
	}
}
