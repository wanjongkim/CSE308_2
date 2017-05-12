/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Shawn
 */
@Entity
@Table(name = "playingmovies")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlayingMovie.findAll", query = "SELECT p FROM PlayingMovie p")
    , @NamedQuery(name = "PlayingMovie.findByMovieID", query = "SELECT p FROM PlayingMovie p WHERE p.movieID = :movieID")
    , @NamedQuery(name = "PlayingMovie.findByTitle", query = "SELECT p FROM PlayingMovie p WHERE p.title = :title")
    , @NamedQuery(name = "PlayingMovie.findByRating", query = "SELECT p FROM PlayingMovie p WHERE p.rating = :rating")
    , @NamedQuery(name = "PlayingMovie.findByReleaseDate", query = "SELECT p FROM PlayingMovie p WHERE p.releaseDate = :releaseDate")
    , @NamedQuery(name = "PlayingMovie.findByRuntime", query = "SELECT p FROM PlayingMovie p WHERE p.runtime = :runtime")
    , @NamedQuery(name = "PlayingMovie.findByPlot", query = "SELECT p FROM PlayingMovie p WHERE p.plot = :plot")
    , @NamedQuery(name = "PlayingMovie.findByHomepage", query = "SELECT p FROM PlayingMovie p WHERE p.homepage = :homepage")
    , @NamedQuery(name = "PlayingMovie.findByPosterPath", query = "SELECT p FROM PlayingMovie p WHERE p.posterPath = :posterPath")
    , @NamedQuery(name = "PlayingMovie.findByImdbID", query = "SELECT p FROM PlayingMovie p WHERE p.imdbID = :imdbID")
    , @NamedQuery(name = "PlayingMovie.findByStatus", query = "SELECT p FROM PlayingMovie p WHERE p.status = :status")
    , @NamedQuery(name = "PlayingMovie.findByRatedPeople", query = "SELECT p FROM PlayingMovie p WHERE p.ratedPeople = :ratedPeople")
    , @NamedQuery(name = "PlayingMovie.findByTrailer", query = "SELECT p FROM PlayingMovie p WHERE p.trailer = :trailer")
    , @NamedQuery(name = "PlayingMovie.findByVideo", query = "SELECT p FROM PlayingMovie p WHERE p.video = :video")
    , @NamedQuery(name = "PlayingMovie.findByPicture", query = "SELECT p FROM PlayingMovie p WHERE p.picture = :picture")})
public class PlayingMovie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "movieID")
    private Integer movieID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "rating")
    private String rating;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "releaseDate")
    private String releaseDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "runtime")
    private String runtime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "plot")
    private String plot;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "homepage")
    private String homepage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "posterPath")
    private String posterPath;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "imdbID")
    private String imdbID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ratedPeople")
    private int ratedPeople;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "trailer")
    private String trailer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "video")
    private String video;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "picture")
    private String picture;
    @Lob
    @Size(max = 16777215)
    @Column(name = "reviews")
    private String reviews;
    @JoinColumn(name = "genre", referencedColumnName = "genreID")
    @ManyToOne(optional = false)
    private Genre genre;

    public PlayingMovie() {
    }

    public PlayingMovie(Integer movieID) {
        this.movieID = movieID;
    }
    
    public PlayingMovie(String title, String rating, String releaseDate, String runtime, String plot, String homepage, String posterPath, String imdbID, String status, int ratedPeople, String trailer, String video, String picture) {
        this.title = title;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.runtime = runtime;
        this.plot = plot;
        this.homepage = homepage;
        this.posterPath = posterPath;
        this.imdbID = imdbID;
        this.status = status;
        this.ratedPeople = ratedPeople;
        this.trailer = trailer;
        this.video = video;
        this.picture = picture;
    }

    public PlayingMovie(Integer movieID, String title, String rating, String releaseDate, String runtime, String plot, String homepage, String posterPath, String imdbID, String status, int ratedPeople, String trailer, String video, String picture) {
        this.movieID = movieID;
        this.title = title;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.runtime = runtime;
        this.plot = plot;
        this.homepage = homepage;
        this.posterPath = posterPath;
        this.imdbID = imdbID;
        this.status = status;
        this.ratedPeople = ratedPeople;
        this.trailer = trailer;
        this.video = video;
        this.picture = picture;
    }

    public Integer getMovieID() {
        return movieID;
    }

    public void setMovieID(Integer movieID) {
        this.movieID = movieID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRatedPeople() {
        return ratedPeople;
    }

    public void setRatedPeople(int ratedPeople) {
        this.ratedPeople = ratedPeople;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movieID != null ? movieID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlayingMovie)) {
            return false;
        }
        PlayingMovie other = (PlayingMovie) object;
        if ((this.movieID == null && other.movieID != null) || (this.movieID != null && !this.movieID.equals(other.movieID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.PlayingMovie[ movieID=" + movieID + " ]";
    }
    
}
