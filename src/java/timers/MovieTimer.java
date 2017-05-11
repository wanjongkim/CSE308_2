/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timers;

import daos.GenreDAO;
import daos.MovieDAO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import models.Genre;
import models.Movie;
import models.PlayingMovie;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Shawn
 */
@Singleton
public class MovieTimer {
    
    @EJB
    GenreDAO gDAO;
    @EJB
    MovieDAO mDAO;
    private int pageIndex = 1000; 
    private final String key = "318fa165649de5b30b74568e44512dce";
    
    @Schedule(dayOfWeek = "*", month = "*", hour = "*", dayOfMonth = "*", year = "*", minute = "*", second = "1", persistent = false)
    //@Schedule(dayOfWeek = "*", month = "*", dayOfMonth = "Last", persistent = false)
    public void myTimer() {
        retrieveMovieInfoFromServer();
    }

    private void retrieveMovieInfoFromServer() {
        JSONParser parser = new JSONParser();
        try {
            String urlForMovies = "https://api.themoviedb.org/3/discover/movie?api_key=" + key + "&language=en-US&sort_by=release_date.desc&include_adult=false&include_video=true&page=" + pageIndex;
            URL u = new URL(urlForMovies);
            HttpURLConnection con = (HttpURLConnection) u.openConnection();
            con.setRequestMethod("GET");
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String movieInfo = br.readLine();
            JSONObject entireJSON = (JSONObject) parser.parse(movieInfo);
            JSONArray results = (JSONArray) entireJSON.get("results");
            con.disconnect();
            br.close();
            for(int i=0; i<results.size(); i++) {
                JSONObject singleMovie = (JSONObject) results.get(i);
                String movieID = singleMovie.get("id").toString();
                String urlForMovieDetails = "https://api.themoviedb.org/3/movie/"+movieID+"?api_key="+key+"&append_to_response=videos,images";
                URL u2 = new URL(urlForMovieDetails);
                HttpURLConnection con2 = (HttpURLConnection) u2.openConnection();
                con2.setRequestMethod("GET");
                BufferedReader br2 = new BufferedReader(new InputStreamReader(con2.getInputStream()));
                String movieInfo2 = br2.readLine();
                JSONObject entireJSON2 = (JSONObject) parser.parse(movieInfo2);
                String homepage = "";
                String imdbID = "";
                String title = "";
                String releaseDate = "";
                String runtime = "";
                String status = "";
                String overview = "";
                String posterPath = "";
                if(entireJSON2.get("homepage") != null)
                    homepage = entireJSON2.get("homepage").toString();
                if(entireJSON2.get("imdb_id") != null)
                    imdbID = entireJSON2.get("imdb_id").toString();
                if(entireJSON2.get("title") != null)
                    title = entireJSON2.get("title").toString();
                if(entireJSON2.get("release_date") != null)
                    releaseDate = entireJSON2.get("release_date").toString();
                if(entireJSON2.get("poster_path") != null) {
                    posterPath = entireJSON2.get("poster_path").toString();
                }
                if(entireJSON2.get("runtime") != null)
                    runtime = entireJSON2.get("runtime").toString();
                if(entireJSON2.get("status") != null)
                    status = entireJSON2.get("status").toString();
                if(entireJSON2.get("overview") != null)
                    overview = entireJSON2.get("overview").toString();
                if(title == null || title.equalsIgnoreCase("")) {
                    title = "null";
                }
                if(releaseDate == null || releaseDate.equalsIgnoreCase("")) {
                    releaseDate = "TBD";
                }
                if(runtime == null || runtime.equalsIgnoreCase("")) {
                    runtime = "unknown";
                }
                if(homepage == null || homepage.equalsIgnoreCase("")) {
                    homepage = "none";
                }
                if(posterPath == null || posterPath.equalsIgnoreCase("")) {
                    posterPath = "none";
                }
                if(imdbID == null || imdbID.equalsIgnoreCase("")) {
                    imdbID = "none";
                }
                if(status == null || status.equalsIgnoreCase("")) {
                    status = "TBD";
                }
                if(overview == null || overview.equalsIgnoreCase("")) {
                    overview = "unknown";
                }
                JSONArray genres = (JSONArray) entireJSON2.get("genres");
                List<String> l = new ArrayList();
                for(int j=0; j<genres.size(); j++) {
                    JSONObject o = (JSONObject) genres.get(j);
                    if(o.get("name")!=null) {
                        l.add(o.get("name").toString().toLowerCase());
                    }
                }
                JSONObject videos = (JSONObject) entireJSON2.get("videos");
                JSONArray videoResults = (JSONArray) videos.get("results");
                String videoPaths = "none";
                String trailerPath = "none";
                boolean firstTime = true;
                for(int j=0; j<videoResults.size(); j++) {
                    JSONObject o = (JSONObject) videoResults.get(j);
                    if(o.get("key")!=null) {
                        String videoKey = o.get("key").toString();
                        if(firstTime) {
                            videoPaths = "";
                            videoPaths = videoPaths.concat(videoKey);
                            trailerPath = videoKey;
                            firstTime = false;
                        }
                        else {
                            videoPaths = videoPaths.concat(", " + videoKey);
                        }
                    }
                    if(j>=3) {
                        break;
                    }
                }
                videoPaths = videoPaths.trim();
                String genre = "";
                for(int j=0; j<l.size(); j++) {
                    if(j == 0)
                        genre = genre.concat(l.get(j));
                    else
                        genre = genre.concat(", " + l.get(j));
                }
                genre = genre.trim();
                JSONObject images = (JSONObject) entireJSON2.get("images");
                JSONArray imageResults = (JSONArray) images.get("backdrops");
                String imagePaths = "none";
                boolean firstTime2 = true;
                for(int j=0; j<imageResults.size(); j++) {
                    JSONObject o = (JSONObject) imageResults.get(j);
                    if(o.get("file_path")!=null) {
                        String imageKey = o.get("file_path").toString();
                        if(firstTime2) {
                            imagePaths = "";
                            imagePaths = imagePaths.concat(imageKey);
                            firstTime2 = false;
                        }
                        else {
                            imagePaths = imagePaths.concat(", " + imageKey);
                        }
                    }
                    if(j>=3) {
                        break;
                    }
                }
                Movie pm = new Movie(title, "0", releaseDate, runtime, overview, homepage, posterPath, imdbID, status, 0, trailerPath, imagePaths, videoPaths);
                
                Genre gen = gDAO.findGenre(genre);
                
                if(gen == null && genre != null && !genre.equals("")) {
                    gen = new Genre(genre);
                    gDAO.create(gen);
                }
                else {
                    gen = gDAO.findGenre("none");
                    if(gen == null) {
                        gen = new Genre("none");
                        gDAO.create(gen);
                    }
                }
                String movieTitle = title;
                movieTitle = movieTitle.replaceAll("'", "''");
                pm.setGenre(gen);
                mDAO.create(pm);
                Movie pm2 = mDAO.findMovie(movieTitle);
                if(pm2 != null) {
                    gen.getMovieSet().add(pm);
                }
                gDAO.edit(gen);
                
                con2.disconnect();
                br2.close();
            }
            pageIndex--;
        } catch(Exception ex) {
            System.out.println(ex);
        }
        System.out.println("Finished Updating");
    }
}
