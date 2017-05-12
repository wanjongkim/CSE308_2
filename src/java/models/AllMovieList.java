/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Shawn
 */
public class AllMovieList implements Serializable {
    private List l;
    public AllMovieList() {
        
    }
    public AllMovieList(List l) {
        this.l = l;
    }

    /**
     * @return the l
     */
    public List getL() {
        return l;
    }

    /**
     * @param l the l to set
     */
    public void setL(List l) {
        this.l = l;
    }
    
}
