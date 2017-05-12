/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import daos.MovieDAO;
import daos.PlayingMovieDAO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
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
    
    private Map moviesPlaying = new HashMap();
    private List<PlayingMovie> currentlyPlaying;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("movieManager", this);
        currentlyPlaying = pmd.findAll();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
    
    public List<PlayingMovie> getCurrentlyPlaying() {
        return currentlyPlaying;
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
    
    public void update(PlayingMovie movie) {
        pmd.edit(movie);
    }
    
}