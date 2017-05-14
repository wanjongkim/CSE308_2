/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import models.Movie;
import models.PlayingMovie;

/**
 *
 * @author Shawn
 */
@Stateless
public class MovieDAO extends AbstractDAO<Movie> {

    @PersistenceContext(unitName = "InDangoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MovieDAO() {
        super(Movie.class);
    }
    
    public Movie findMovie(String movieName) {
        movieName = movieName.replaceAll("'", "''");
        Query query = em.createNativeQuery("SELECT * FROM movies WHERE title='" + movieName + "';", Movie.class);
        Movie movie = null;
        List<Movie> l = query.getResultList();
        if(l.size() >= 1) {
            movie = l.get(0);
        }
        /*
        try {
            movie = (Movie) query.getSingleResult(); 
        } catch(NoResultException ex) {
            return null;
        }
        */
        return movie;
    }
    
    public List<Movie> searchMovie(String searchQuery) {
        searchQuery = searchQuery.replaceAll("'", "''");
        Query query = em.createNativeQuery("SELECT * FROM movies WHERE title LIKE '%" + searchQuery + "%';", Movie.class);
        List<Movie> l = query.getResultList();
        return l;
    }
    
}
