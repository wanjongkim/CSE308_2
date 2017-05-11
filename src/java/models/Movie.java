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
@Table(name = "movies")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m")
    , @NamedQuery(name = "Movie.findByMovieID", query = "SELECT m FROM Movie m WHERE m.movieID = :movieID")
    , @NamedQuery(name = "Movie.findByTitle", query = "SELECT m FROM Movie m WHERE m.title = :title")
    , @NamedQuery(name = "Movie.findByRating", query = "SELECT m FROM Movie m WHERE m.rating = :rating")
    , @NamedQuery(name = "Movie.findByReleaseDate", query = "SELECT m FROM Movie m WHERE m.releaseDate = :releaseDate")
    , @NamedQuery(name = "Movie.findByRuntime", query = "SELECT m FROM Movie m WHERE m.runtime = :runtime")
    , @NamedQuery(name = "Movie.findByPlot", query = "SELECT m FROM Movie m WHERE m.plot = :plot")
    , @NamedQuery(name = "Movie.findByHomepage", query = "SELECT m FROM Movie m WHERE m.homepage = :homepage")
    , @NamedQuery(name = "Movie.findByPosterPath", query = "SELECT m FROM Movie m WHERE m.posterPath = :posterPath")
    , @NamedQuery(name = "Movie.findByImdbID", query = "SELECT m FROM Movie m WHERE m.imdbID = :imdbID")
    , @NamedQuery(name = "Movie.findByStatus", query = "SELECT m FROM Movie m WHERE m.status = :status")
    , @NamedQuery(name = "Movie.findByRatedPeople", query = "SELECT m FROM Movie m WHERE m.ratedPeople = :ratedPeople")
    , @NamedQuery(name = "Movie.findByTrailer", query = "SELECT m FROM Movie m WHERE m.trailer = :trailer")
    , @NamedQuery(name = "Movie.findByImage", query = "SELECT m FROM Movie m WHERE m.image = :image")
    , @NamedQuery(name = "Movie.findByVideo", query = "SELECT m FROM Movie m WHERE m.video = :video")})
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "movieID")
    private Integer movieID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "rating")
    private String rating;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "releaseDate")
    private String releaseDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "runtime")
    private String runtime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
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
    @Size(min = 1, max = 70)
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
    @Size(min = 1, max = 200)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "video")
    private String video;
    @JoinColumn(name = "genre", referencedColumnName = "genreID")
    @ManyToOne(optional = false)
    private Genre genre;

    public Movie() {
    }

    public Movie(Integer movieID) {
        this.movieID = movieID;
    }
    
    public Movie(String title, String rating, String releaseDate, String runtime, String plot, String homepage, String posterPath, String imdbID, String status, int ratedPeople, String trailer, String image, String video) {
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
        this.image = image;
        this.video = video;
    }

    public Movie(Integer movieID, String title, String rating, String releaseDate, String runtime, String plot, String homepage, String posterPath, String imdbID, String status, int ratedPeople, String trailer, String image, String video) {
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
        this.image = image;
        this.video = video;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
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
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.movieID == null && other.movieID != null) || (this.movieID != null && !this.movieID.equals(other.movieID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Movie[ movieID=" + movieID + " ]";
    }
    
}
