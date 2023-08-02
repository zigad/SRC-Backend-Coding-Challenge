package si.deisinger.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import si.deisinger.model.Actor;

@ApplicationScoped
public class ActorRepository implements PanacheRepository<Actor> {
}
