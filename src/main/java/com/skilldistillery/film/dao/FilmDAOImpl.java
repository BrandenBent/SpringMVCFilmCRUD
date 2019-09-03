package com.skilldistillery.film.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Component
public class FilmDAOImpl implements FilmDAO {

	// FIELDS

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private static final String userName = "student";
	private static final String password = "student";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////

	// METHODS

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;

		try {
			String sql = "SELECT film.id, title, description," + "release_year, language_id, rental_duration,"
					+ "rental_rate, length, replacement_cost, rating, special_features, language.name" + " FROM film"
					+ " JOIN language ON film.language_id = language.id" + " WHERE film.id = ?";

			// Opening connection to database
			Connection conn = DriverManager.getConnection(URL, userName, password);
			// preparing statement
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("film.id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				int releaseYear = rs.getInt("release_year");
				int languageId = rs.getInt("language_id");
				// int rentalDuration = rs.getInt("rental_duration");
				// double rentalRate = rs.getDouble("rental_rate");
				// int length = rs.getInt("length");
				// double replacement = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				// String specialFeatures = rs.getString("special_features");
				String language = rs.getString("name");

				List<Actor> actors = findActorsByFilmId(filmId);
//				film.setActors(actors);

				film = new Film(id, title, description, releaseYear, languageId, rating, language, actors);

			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return film;
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public List<Film> findFilmByKeyWord(String keyWord) {
		List<Film> films = new ArrayList<Film>();
		Film film = null;
		try {

			String sql = "SELECT film.id, title, description," + "release_year, language_id, rental_duration,"
					+ "rental_rate, length, replacement_cost, rating, special_features, language.name" + " FROM film"
					+ " JOIN language ON film.language_id = language.id" + " WHERE title LIKE ? OR description LIKE ?";

			// Opening connection to database
			Connection conn = DriverManager.getConnection(URL, userName, password);
			// preparing statement
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, ("%" + keyWord + "%"));
			stmt.setString(2, ("%" + keyWord + "%"));
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				int releaseYear = rs.getInt("release_year");
				int languageId = rs.getInt("language_id");
				// int rentalDuration = rs.getInt("rental_duration");
				// double rentalRate = rs.getDouble("rental_rate");
				// int length = rs.getInt("length");
				// double replacement = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				// String specialFeatures = rs.getString("special_features");
				String language = rs.getString("name");

				List<Actor> actors = findActorsByFilmId(id);

				film = new Film(id, title, description, releaseYear, languageId, rating, language, actors);
				film.setActors(actors);
				films.add(film);

			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		if (films.size() == 0) {
			System.out.println("No results found");

		}
		return films;

	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;
		try {

			String sql = "SELECT film.id, film.title, film.description, film.release_year, film.language_id, "
					+ "film.rating " + "FROM film " + "WHERE title like ? " + "OR description like ? ";

			Connection conn = DriverManager.getConnection(URL, userName, password);

			// preparing statement
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				actor = new Actor(id, firstName, lastName);

			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return actor;
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////

	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<Actor>();
		String sql = "SELECT a.id, a.first_name, a.last_name FROM actor a "
				+ "JOIN film_actor fa ON fa.actor_id = a.id " + "JOIN film f ON f.id = fa.film_id         "
				+ "WHERE f.id = ?";
		try {
			// Opening connection to database
			Connection conn = DriverManager.getConnection(URL, userName, password);

			// preparing statement for database, set variable to question mark
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				Actor a = new Actor(id, firstName, lastName);
				actors.add(a);

			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return actors;

	}

	// SAME AS ^^ But the String Version

	@Override
	public List<Actor> findActorsByFilmId(String filmId) {
		List<Actor> actors = new ArrayList<Actor>();
		String sql = "SELECT a.id, a.first_name, a.last_name FROM actor a "
				+ "JOIN film_actor fa ON fa.actor_id = a.id " + "JOIN film f ON f.id = fa.film_id         "
				+ "WHERE f.id = ?";
		try {
			// Opening connection to database
			Connection conn = DriverManager.getConnection(URL, userName, password);

			// preparing statement for database, set variable to question mark
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, filmId);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				Actor a = new Actor(id, firstName, lastName);
				actors.add(a);

			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return actors;
	}

///////////////////////////////////////////////////////////////////////
	@Override
	public Film newFilm(Film film) {
		FilmDAOImpl filmDao = new FilmDAOImpl();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, userName, password);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "INSERT INTO film (title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features) "
					+ " VALUES (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setInt(4, film.getLanguageId());
			stmt.setInt(5, film.getRentalDuration());
			stmt.setDouble(6, film.getRentalRate());
			stmt.setInt(7, film.getLength());
			stmt.setDouble(8, film.getReplacement());
			stmt.setString(9, film.getRating());
			stmt.setString(10, film.getSpecialFeatures());
			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					int newFilmId = keys.getInt(1);
					film.setId(newFilmId);
					List<Actor> actors = filmDao.findActorsByFilmId(newFilmId);
					if (actors != null && actors.size() > 0) {
						sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
						stmt = conn.prepareStatement(sql);
						for (Actor actor : actors) {
							stmt.setInt(1, newFilmId);
							stmt.setInt(2, actor.getId());
							updateCount = stmt.executeUpdate();
						}
					}
//					if (film.getCategoryId() != 0) {
//						sql = "INSERT INTO film_category (film_id, category_id) VALUES (?,?)";
//						stmt = conn.prepareStatement(sql);
//						stmt.setInt(1, newFilmId);
//						stmt.setInt(2, film.getCategoryId());
//						updateCount = stmt.executeUpdate();
//					}
				}
			} else {
				film = null;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			throw new RuntimeException("Error inserting film " + film);
		} finally {
			try {
				conn.commit();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return film;
	}

	public boolean deleteFilm(Film film) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, userName, password);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "DELETE FROM film_actor WHERE film_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, film.getId());
			int updateCount = stmt.executeUpdate();
			sql = "DELETE FROM film_category WHERE film_id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, film.getId());
			updateCount = stmt.executeUpdate();
			sql = "DELETE FROM film WHERE id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, film.getId());
			updateCount = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					System.err.println("Error Deleting the film requested");
				}
			}
			return false;
		} finally {
			try {
				conn.commit();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public boolean putFilm(Film film) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, userName, password);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "UPDATE film SET title=?, description=?, release_year=?, language_id=?, rental_duration=?, "
					+ "rental_rate=?, length=?, replacement_cost=?, rating=?, special_features=? WHERE id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setInt(4, film.getLanguageId());
			stmt.setInt(5, film.getRentalDuration());
			stmt.setDouble(6, film.getRentalRate());
			stmt.setInt(7, film.getLength());
			stmt.setDouble(8, film.getReplacement());
			stmt.setString(9, film.getRating());
			stmt.setString(10, film.getSpecialFeatures());
			stmt.setInt(11, film.getId());
			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				// Replace actor's film list
				sql = "DELETE FROM film_actor WHERE film_id = ?";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, film.getId());
				updateCount = stmt.executeUpdate();
			}
			stmt.setInt(1, film.getId());
			updateCount = stmt.executeUpdate();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, film.getId());
			updateCount = stmt.executeUpdate();
		} finally {
			try {
				conn.commit();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
		}
	}
}
