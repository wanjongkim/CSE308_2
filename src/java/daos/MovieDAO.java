/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import javax.ejb.Singleton;
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
@Singleton
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
        Query query = em.createNativeQuery("SELECT * FROM playingmovies WHERE title='" + movieName + "';", Movie.class);
        Movie movie = null;
        try {
            movie = (Movie) query.getSingleResult();
        } catch(NoResultException ex) {
            return null;
        }
        return movie;
    }
    
}
