/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import models.Genre;
import models.Movie;

/**
 *
 * @author Shawn
 */
@Stateless
public class GenreDAO extends AbstractDAO<Genre> {

    @PersistenceContext(unitName = "InDangoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GenreDAO() {
        super(Genre.class);
    }
    
    public Genre findGenre(String genreName) {
        Query query = em.createNativeQuery("SELECT * FROM genre WHERE genre='" + genreName + "';", Genre.class);
        Genre genre = null;
        try {
            genre = (Genre) query.getSingleResult();
        } catch(NoResultException ex) {
            return null;
        }
        return genre;
    }
    
    public List findFilteredMovies(String filter) {
        Query query = em.createNativeQuery("SELECT * FROM genre WHERE genre LIKE '%" + filter + "%';", Genre.class);
        List<Genre> l = query.getResultList();
        List<Movie> filteredMovies = new ArrayList();
        for(Genre g : l) {
            Set<Movie> s = g.getMovieSet();
            for(Movie m : s) {
                filteredMovies.add(m);
            }
        }
        return filteredMovies;
    }
}
