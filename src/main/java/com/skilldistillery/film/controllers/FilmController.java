package com.skilldistillery.film.controllers;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mysql.jdbc.Connection;
import com.skilldistillery.film.dao.FilmDAO;
import com.skilldistillery.film.dao.FilmDAOImpl;
import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	@Autowired
	FilmDAO dao;

	@ModelAttribute("film")
	public Film initFilm() {
		return new Film(0, null, null, 0, 0, null, null, null);
	}

//	  @RequestMapping(path = "searchId.do", params = "search", method = RequestMethod.GET)
//	  public ModelAndView getFilmById(int filmId) {
//		dao = new FilmDAOImpl();
//	    ModelAndView mv = new ModelAndView();
//	    Film film = dao.findFilmById(filmId);
//	    mv.addObject("film", film);
//	    mv.setViewName("WEB-INF/result.jsp");
//	    return mv;
//	  }

	@RequestMapping(path = "searchid.do", params = "id", method = RequestMethod.GET)
	public ModelAndView getFilmById(int id) {
		Film film = null;
		System.out.println(film);
		film = dao.findFilmById(id);
		ModelAndView mv = new ModelAndView();
		if (film != null) {
			List<Actor> actors = dao.findActorsByFilmId("" + film.getId());
			mv.addObject("actors", actors);
		}
		System.out.println(film);
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/idResults.jsp");
		return mv;
	}

	@RequestMapping(path = "filmbykeyword.do", params = "description", method = RequestMethod.GET)
	public ModelAndView getFilmByKeyword(String description) {
		ModelAndView mv = new ModelAndView();
		List<Film> films = dao.findFilmByKeyWord(description);
		for (Film film : films) {
			List<Actor> actors = dao.findActorsByFilmId("" + film.getId());
			film.setActors(actors);
			System.out.println(actors);
		}
		mv.addObject("film", films);
		mv.setViewName("WEB-INF/keywordResults.jsp");
		return mv;
	}


	@RequestMapping(path = "addedFilm.do", method = RequestMethod.POST)
	public String addFilmToDB(Film film, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		dao.newFilm(film);
		redir.addFlashAttribute("filmNew", film);
//		mv.addObject("film", film);
//		mv.setViewName("WEB-INF/addNewFilm.jsp");
		return "redirect:addNewFilm.do";
	}

	@RequestMapping(path = "addNewFilm.do", method = RequestMethod.GET)
	public ModelAndView addFilm() {
		ModelAndView mv = new ModelAndView();
//		Film film = null;
//		film = film.
		mv.setViewName("WEB-INF/addNewFilm.jsp");
		return mv;
	}
	
	@RequestMapping(path = "editedFilm.do", method = RequestMethod.POST)
	public String updateFilm(Film film, RedirectAttributes redir) {
		dao.putFilm(film);
		redir.addFlashAttribute("filmAdd", film);
		return "redirect:filmEditAdded.do";
	}
	
	@RequestMapping(path = "filmEditAdded.do", method = RequestMethod.GET)
	public ModelAndView filmEditAdded() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/updated.jsp");
		return mv;
	}

	@RequestMapping(path = "deleteFilm.do", method = RequestMethod.POST)
	public ModelAndView deleteFilm(Film film) {
		ModelAndView mv = new ModelAndView();
		boolean deleteFilm = dao.deleteFilm(film);
		if (deleteFilm) {
			mv.setViewName("WEB-INF/deleted.jsp");
		} else {
			mv.setViewName("WEB-INF/errorDeletion.jsp");
		}
		return mv;
	}
	
	@RequestMapping(path = "UPDATEFILM.do", method = RequestMethod.GET)
	public ModelAndView filmUpdated(Film film) {
		ModelAndView mv = new ModelAndView();
		film = dao.findFilmById(film.getId());
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/modifyFilm.jsp");
		return mv;
	}

}
