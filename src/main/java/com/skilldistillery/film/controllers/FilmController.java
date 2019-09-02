package com.skilldistillery.film.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.dao.FilmDAOImpl;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	FilmDAOImpl dao;

//	  @RequestMapping(path = "searchId.do", params = "search", method = RequestMethod.GET)
//	  public ModelAndView getFilmById(int filmId) {
//		dao = new FilmDAOImpl();
//	    ModelAndView mv = new ModelAndView();
//	    Film film = dao.findFilmById(filmId);
//	    mv.addObject("film", film);
//	    mv.setViewName("WEB-INF/result.jsp");
//	    return mv;
//	  }

	@RequestMapping(path = "searchId.do", params = "search", method = RequestMethod.GET)
	public ModelAndView getFilmById(int search) {
		Film film = null;
		film = dao.findFilmById(search);
		ModelAndView mv = new ModelAndView();
		System.out.println(film);
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/result.jsp");
		return mv;
	}

}
