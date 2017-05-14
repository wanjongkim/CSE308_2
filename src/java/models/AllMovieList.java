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
    private int pageLimit;
    private int currentPage;
    private String genre;
    public AllMovieList() {
        
    }
    public AllMovieList(List l, int pageLimit, int currentPage, String genre) {
        this.l = l;
        this.pageLimit = pageLimit;
        this.currentPage = currentPage;
        this.genre = genre;
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

    /**
     * @return the pageLimit
     */
    public int getPageLimit() {
        return pageLimit;
    }

    /**
     * @param pageLimit the pageLimit to set
     */
    public void setPageLimit(int pageLimit) {
        this.pageLimit = pageLimit;
    }

    /**
     * @return the currentPage
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * @param currentPage the currentPage to set
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
}
