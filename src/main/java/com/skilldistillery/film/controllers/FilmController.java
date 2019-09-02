package src.main.java.com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.dao.FilmDAOImpl;

public class FilmController {
	@Autowired
	FilmDAOImpl dao;
	
	  @RequestMapping(path = "searchId.do", params = "filmId", method = RequestMethod.GET)
	  public ModelAndView getFilmById(int filmId) {
		dao = new FilmDAOImpl();
	    ModelAndView mv = new ModelAndView();
	    mv.addObject("film", dao.findFilmById(filmId));
	    mv.setViewName("WEB-INF/result.jsp");
	    return mv;
	  }

}
