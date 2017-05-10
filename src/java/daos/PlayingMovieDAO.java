/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import models.Account;
import models.PlayingMovie;

/**
 *
 * @author Shawn
 */
@Stateless
public class PlayingMovieDAO extends AbstractDAO<PlayingMovie> {

    @PersistenceContext(unitName = "InDangoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlayingMovieDAO() {
        super(PlayingMovie.class);
    }
    
    public void removeAll() {
        Query query = em.createNativeQuery("TRUNCATE TABLE playingmovies;");
        query.executeUpdate();
    }
    
    public PlayingMovie findMovie(String movieName) {
        Query query = em.createNativeQuery("SELECT * FROM playingmovies WHERE title='" + movieName + "';", PlayingMovie.class);
        PlayingMovie movie = null;
        try {
            movie = (PlayingMovie) query.getSingleResult();
        } catch(NoResultException ex) {
            return null;
        }
        return movie;
    }
    
}
