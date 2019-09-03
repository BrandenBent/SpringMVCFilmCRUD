package com.skilldistillery.film.dao;

import java.util.List;
import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {
	public Film findFilmById(int filmId);

	public Actor findActorById(int actorId);

	public List<Actor> findActorsByFilmId(String choice);

	public List<Film> findFilmByKeyWord(String keyWord);

	public Film newFilm(Film film);
	
	public boolean deleteFilm(Film film);
	
	public boolean putFilm(Film film);
	
}