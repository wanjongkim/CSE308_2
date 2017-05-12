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
public class Review implements Serializable {
    private List li;
    
    public Review() {
        
    }
    
    public Review(List li) {
        this.li = li;
    }

    /**
     * @return the li
     */
    public List getLi() {
        return li;
    }

    /**
     * @param li the li to set
     */
    public void setLi(List li) {
        this.li = li;
    }
}
