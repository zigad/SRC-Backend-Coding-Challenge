package si.deisinger.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@JsonbPropertyOrder({"id", "firstName", "lastName", "birthday", "movies"})
public class Actor extends PanacheEntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonbProperty("id")
	private Long id;

	@JsonbProperty("firstName")
	private String firstName;

	@JsonbProperty("lastName")
	private String lastName;

	@JsonbProperty("birthday")
	private LocalDate birthday;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "movie_actor",
			joinColumns = @JoinColumn(name = "actor_id"),
			inverseJoinColumns = @JoinColumn(name = "movie_id")
	)
	private List<Movie> movies = new ArrayList<>(); // Initialize movies to an empty list

	@JsonbProperty("movies") // Custom serialization for the 'movies' field
	public List<String> getMovies() {
		if (movies == null) {
			return Collections.emptyList(); // Return an empty list if actors are null
		}
		return movies.stream().map(Movie::getTitle).collect(Collectors.toList());
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public void addMovie(int id){
		this.movies.add(Movie.findById(id));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}
}