package si.deisinger.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import si.deisinger.model.Actor;
import si.deisinger.model.Movie;
import si.deisinger.repository.ActorRepository;

import java.util.List;

@ApplicationScoped
public class ActorService {

	@Inject
	ActorRepository actorRepository;

	@PersistenceContext
	EntityManager entityManager;

	public List<Actor> getAllActors() {
		return actorRepository.listAll();
	}

	public Actor getActorById(Long id) {
		return actorRepository.findById(id);
	}

	@Transactional
	public Actor createActor(Actor actor) {
		actor.persist();
		return actor;
	}

	@Transactional
	public Actor updateActor(Long id, Actor updatedActor) {
		Actor actor = actorRepository.findById(id);
		if (actor != null) {
			actor.setFirstName(updatedActor.getFirstName());
			actor.setLastName(updatedActor.getLastName());
			actor.setBirthday(updatedActor.getBirthday());
		}
		return actor;
	}

	@Transactional
	public boolean deleteActor(Long id) {
		Actor actor = actorRepository.findById(id);
		if (actor != null) {
			actorRepository.delete(actor);
			return true;
		}
		return false;
	}

	public List<Actor> getPaginatedActors(int page, int pageSize) {
		int offset = (page - 1) * pageSize;
		return entityManager
				.createQuery("SELECT a FROM Actor a", Actor.class)
				.setFirstResult(offset)
				.setMaxResults(pageSize)
				.getResultList();
	}

	public List<Actor> searchActors(String keyword) {
		return entityManager
				.createQuery("SELECT a FROM Actor a WHERE a.firstName LIKE :keyword OR a.lastName LIKE :keyword", Actor.class)
				.setParameter("keyword", "%" + keyword + "%")
				.getResultList();
	}
}
