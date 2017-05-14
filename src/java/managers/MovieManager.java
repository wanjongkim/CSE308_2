/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import daos.GenreDAO;
import daos.MovieDAO;
import daos.PlayingMovieDAO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import models.Genre;
import models.Movie;
import models.PlayingMovie;

/**
 *
 * @author Shawn
 */
@WebListener
public class MovieManager implements ServletContextListener{

    @EJB
    PlayingMovieDAO pmd;
    @EJB
    MovieDAO mDAO;
    @EJB
    GenreDAO gDAO;
    
    private List<Movie> allMovies;
    private List<PlayingMovie> currentlyPlaying;
    private List<Movie> comedy;
    private List<Movie> action;
    private List<Movie> horror;
    private List<Movie> documentary;
    private List<Movie> animation;
    private List<Movie> mystery;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("movieManager", this);
        currentlyPlaying = pmd.findAll();
        allMovies = mDAO.findAll();
        comedy = getFilteredMovies("comedy");
        action = getFilteredMovies("action");
        horror = getFilteredMovies("horror");
        documentary = getFilteredMovies("documentary");
        animation = getFilteredMovies("animation");
        mystery = getFilteredMovies("mystery");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
    
    public List<PlayingMovie> getCurrentlyPlaying() {
        return currentlyPlaying;
    }
    
    public List<Movie> getAllMovies() {
        return allMovies;
    }
    
    public List<Movie> getFilteredMovies(String filter) {
        //find the filter movies
        List<Movie> l = gDAO.findFilteredMovies(filter);
        return l;
    }
    
    public PlayingMovie findMovie(String movieName) {
        PlayingMovie pm = pmd.findMovie(movieName);
        if(pm == null) {
            return null;
        }
        else {
            return pm;
        }
    }
    
    public Movie findMovie2(String movieName) {
        Movie m = mDAO.findMovie(movieName);
        if(m == null) {
            return null;
        }
        else {
            return m;
        }
    }
    //for movies
    public List selectAll() {
        return mDAO.findAll();
    }
    
    public List<Movie> searchMovie(String searchQuery) {
        return mDAO.searchMovie(searchQuery);
    }
    
    public void update(PlayingMovie movie) {
        pmd.edit(movie);
    }

    /**
     * @return the comedy
     */
    public List<Movie> getComedy() {
        return comedy;
    }

    /**
     * @return the action
     */
    public List<Movie> getAction() {
        return action;
    }

    /**
     * @return the horror
     */
    public List<Movie> getHorror() {
        return horror;
    }

    /**
     * @return the documentary
     */
    public List<Movie> getDocumentary() {
        return documentary;
    }

    /**
     * @return the animation
     */
    public List<Movie> getAnimation() {
        return animation;
    }

    /**
     * @return the mystery
     */
    public List<Movie> getMystery() {
        return mystery;
    }
    
}