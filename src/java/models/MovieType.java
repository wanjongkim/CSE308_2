/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author Shawn
 */
public class MovieType implements Serializable {
    private String movieType;
    
    public MovieType() {
        
    }
    
    public MovieType(String mType) {
        this.movieType = mType;
    }

    /**
     * @return the mType
     */
    public String getMovieType() {
        return movieType;
    }

    /**
     * @param mType the mType to set
     */
    public void setMovieType(String mType) {
        this.movieType = mType;
    }
}
