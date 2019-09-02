package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.dao.FilmDAO;
import com.skilldistillery.film.dao.FilmDAOImpl;
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

	@RequestMapping(path = "searchId.do", params = "id", method = RequestMethod.GET)
	public ModelAndView getFilmById(int id) {
		Film film = null;
		film = dao.findFilmById(id);
		ModelAndView mv = new ModelAndView();
		System.out.println(film);
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/results.jsp");
		return mv;
	}

}
