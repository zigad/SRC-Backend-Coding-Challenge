package si.deisinger.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.persistence.*;

@Entity
@JsonbPropertyOrder({"imdbID", "title", "description", "year",  "pictures"})
public class Movie extends PanacheEntityBase {

	@Id
	@JsonbProperty("imdbID")
	public Long imdbID;

	@JsonbProperty("title")
	public String title;

	@JsonbProperty("description")
	public String description;

	@JsonbProperty("year")
	public Integer year;

	@JsonbProperty("pictures")
	public String pictures; // To make it easier we will just use CSV for urls.

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