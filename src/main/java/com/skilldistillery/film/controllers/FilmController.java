package com.skilldistillery.film.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.dao.FilmDAO;
import com.skilldistillery.film.dao.FilmDAOImpl;
import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	@Autowired
	FilmDAO dao;

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
//		if (film != null) {
//			List<Actor> actors = dao.findActorsByFilmId(film.getId());
//			mv.addObject("actors", actors);
//		}
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

	@RequestMapping(path = "addFilm.do", method = RequestMethod.POST)
	public ModelAndView addFilmToDB() {
		Film film = new Film();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/addFilm.jsp");
		mv.addObject("Film", film);
		return mv;
	}

}
