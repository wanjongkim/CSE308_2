/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shawn
 */
public class PicVideo implements Serializable {
    private List picList;
    private List vidList;
    
    public PicVideo() {
        
    }
    
    public PicVideo(ArrayList picList) {
        this.picList = picList;
    }
    
    public PicVideo(ArrayList picList, ArrayList vidList) {
        this.picList = picList;
        this.vidList = vidList;
    }

    /**
     * @return the picList
     */
    public List getPicList() {
        return picList;
    }

    /**
     * @param picList the picList to set
     */
    public void setPicList(List picList) {
        this.picList = picList;
    }

    /**
     * @return the vidList
     */
    public List getVidList() {
        return vidList;
    }

    /**
     * @param vidList the vidList to set
     */
    public void setVidList(List vidList) {
        this.vidList = vidList;
    }
}
