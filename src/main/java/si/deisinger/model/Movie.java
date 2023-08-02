package si.deisinger.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@JsonbPropertyOrder({"imdbID", "title", "description", "year",  "pictures", "actors"})
public class Movie extends PanacheEntityBase {

	@Id
	@JsonbProperty("imdbID")
	private Long imdbID;

	@JsonbProperty("title")
	private String title;

	@JsonbProperty("description")
	private String description;

	@JsonbProperty("year")
	private Integer year;

	@JsonbProperty("pictures")
	private String pictures; // To make it easier we will just use CSV for urls.

	@ManyToMany
	@JoinTable(
			name = "movie_actor",
			joinColumns = @JoinColumn(name = "movie_id"),
			inverseJoinColumns = @JoinColumn(name = "actor_id")
	)
	@JsonbTransient // Exclude this field from the default serialization
	private List<Actor> actors = new ArrayList<>(); // Initialize actors to an empty list

	@JsonbProperty("actors") // Custom serialization for the 'actors' field
	public List<String> getActorNames() {
		if (actors == null) {
			return Collections.emptyList(); // Return an empty list if actors are null
		}
		return actors.stream().map(Actor::getFullName).collect(Collectors.toList());
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public void addActor(int id){
		this.actors.add(Actor.findById(id));
	}

	public Long getImdbID() {
		return imdbID;
	}

	public void setImdbID(Long imdbID) {
		this.imdbID = imdbID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPictures() {
		return pictures;
	}

	public void setPictures(String pictures) {
		this.pictures = pictures;
	}


}