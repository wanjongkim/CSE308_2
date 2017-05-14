/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.List;

public class SearchResult implements Serializable {
    private int numMovies;
    private List<Movie> l;
    private String q;

    public SearchResult() {
        
    }
    
    public SearchResult(List<Movie> l, int numMovies, String q) {
        this.l = l;
        this.numMovies = numMovies;
        this.q = q;
    }
    
    /**
     * @return the numMovies
     */
    public int getNumMovies() {
        return numMovies;
    }

    /**
     * @param numMovies the numMovies to set
     */
    public void setNumMovies(int numMovies) {
        this.numMovies = numMovies;
    }

    /**
     * @return the l
     */
    public List<Movie> getL() {
        return l;
    }

    /**
     * @param l the l to set
     */
    public void setL(List<Movie> l) {
        this.l = l;
    }

    /**
     * @return the q
     */
    public String getQ() {
        return q;
    }

    /**
     * @param q the q to set
     */
    public void setQ(String q) {
        this.q = q;
    }
    
}
