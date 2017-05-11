/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Shawn
 */
@Entity
@Table(name = "genre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Genre.findAll", query = "SELECT g FROM Genre g")
    , @NamedQuery(name = "Genre.findByGenreID", query = "SELECT g FROM Genre g WHERE g.genreID = :genreID")
    , @NamedQuery(name = "Genre.findByGenre", query = "SELECT g FROM Genre g WHERE g.genre = :genre")})
public class Genre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "genreID")
    private Integer genreID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "genre")
    private String genre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
    private Set<Movie> movieSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
    private Set<PlayingMovie> playingMovieSet;

    public Genre() {
    }

    public Genre(Integer genreID) {
        this.genreID = genreID;
    }
    
    public Genre(String genre) {
        this.genre = genre;
    }

    public Genre(Integer genreID, String genre) {
        this.genreID = genreID;
        this.genre = genre;
    }

    public Integer getGenreID() {
        return genreID;
    }

    public void setGenreID(Integer genreID) {
        this.genreID = genreID;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @XmlTransient
    public Set<Movie> getMovieSet() {
        return movieSet;
    }

    public void setMovieSet(Set<Movie> movieSet) {
        this.movieSet = movieSet;
    }

    @XmlTransient
    public Set<PlayingMovie> getPlayingMovieSet() {
        return playingMovieSet;
    }

    public void setPlayingMovieSet(Set<PlayingMovie> playingMovieSet) {
        this.playingMovieSet = playingMovieSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (genreID != null ? genreID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genre)) {
            return false;
        }
        Genre other = (Genre) object;
        if ((this.genreID == null && other.genreID != null) || (this.genreID != null && !this.genreID.equals(other.genreID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Genre[ genreID=" + genreID + " ]";
    }
    
}
