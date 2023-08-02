package si.deisinger.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import jakarta.enterprise.context.ApplicationScoped;
import si.deisinger.model.Movie;

@ApplicationScoped
public class MovieRepository implements PanacheRepository<Movie> {
}
