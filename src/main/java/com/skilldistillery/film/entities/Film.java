package com.skilldistillery.film.entities;

import java.util.List;

public class Film {

	// FIELDS

	private int id;

	private String title;

	private String description;

	private int releaseYear;

	private int languageId;

	private int rentalDuration;

	private double rentalRate;

	private int length;

	private double replacementCost;

	private String rating;

	private String specialFeatures;

	private String language;

	private List<Actor> actors;

///////////////////////////////////////////////////////////////////////////////////////////////////////////

	// CONSTRUCTORS

	public Film(int id, String title, String description, int releaseYear, int languageId, String rating,
			String language, List<Actor> actors) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		// this.rentalDuration = rentalDuration;
		// this.rentalRate = rentalRate;
		// this.length = length;
		// this.replacementCost = replacementCost;
		this.rating = rating;
		// this.specialFeatures = specialFeatures;
		this.language = language;
		this.actors = actors;

	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////

	// METHODS

	// GETTERS AND SETTERS

	// ID OF FILM

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// TITLE OF FILM

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// DESCRIPTION OF FILM

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// RELEASE YEAR OF FILM

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	// LANGUAGE ID

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	// DURATION OF FILM

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	// RENTAL RATE OF FILM

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	// LENGTH OF FILM

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	// REPLACEMENT COST OF FILM

	public double getReplacement() {
		return replacementCost;
	}

	public void setReplacement(double replacement) {
		this.replacementCost = replacement;
	}

	// RATING OF FILM

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	// SPECIAL FEATURES OF FILM

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	// ACTORS IN FILM

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;

	}

//	// Iterates through actors
//
//	public void iterateActors(List<Actor> actors) {
//
//		for (Actor actor : actors) {
//			String stringOfActors = actor + "";
//			System.out.println(stringOfActors);
//		}
//	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FILM TITLE: ");
		builder.append(title);
		builder.append("\nDESCRIPTION: ");
		builder.append(description);
		builder.append("\nRELEASE YEAR: ");
		builder.append(releaseYear);
		builder.append("\nRATING: ");
		builder.append(rating);
		builder.append("\nLANGUAGE: ");
		builder.append(language);
//		builder.append("\nACTORS: ");
//		builder.append(actors);
		return builder.toString();
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actors == null) ? 0 : actors.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + languageId;
		result = prime * result + length;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + releaseYear;
		result = prime * result + rentalDuration;
		long temp;
		temp = Double.doubleToLongBits(rentalRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(replacementCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((specialFeatures == null) ? 0 : specialFeatures.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (actors == null) {
			if (other.actors != null)
				return false;
		} else if (!actors.equals(other.actors))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (languageId != other.languageId)
			return false;
		if (length != other.length)
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (releaseYear != other.releaseYear)
			return false;
		if (rentalDuration != other.rentalDuration)
			return false;
		if (Double.doubleToLongBits(rentalRate) != Double.doubleToLongBits(other.rentalRate))
			return false;
		if (Double.doubleToLongBits(replacementCost) != Double.doubleToLongBits(other.replacementCost))
			return false;
		if (specialFeatures == null) {
			if (other.specialFeatures != null)
				return false;
		} else if (!specialFeatures.equals(other.specialFeatures))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}