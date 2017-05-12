/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timers;

import daos.GenreDAO;
import daos.MovieDAO;
import daos.PlayingMovieDAO;
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
import models.PlayingMovie;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@Singleton
public class ServerToServerTimer {

    @EJB
    GenreDAO gDAO;
    @EJB
    PlayingMovieDAO pmDAO;
    @EJB
    MovieDAO mDAO;
    
    private final String key = "318fa165649de5b30b74568e44512dce";
    
    @Schedule(dayOfMonth="Last", persistent=false)
    //@Schedule(dayOfWeek = "*", month = "*", hour = "*", dayOfMonth = "*", year = "*", minute = "*", second = "1", persistent = false)
    public void myTimer() {
        retrieveDataFromDiffServer();
    }

    public void retrieveDataFromDiffServer() {
        JSONParser parser = new JSONParser();
        try {
            String urlForMoviesNowPlaying = "https://api.themoviedb.org/3/movie/now_playing?api_key="+key+"&language=en-US&page=1";
            URL u = new URL(urlForMoviesNowPlaying);
            HttpURLConnection con = (HttpURLConnection) u.openConnection();
            con.setRequestMethod("GET");
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String movieInfo = br.readLine();
            JSONObject entireJSON = (JSONObject) parser.parse(movieInfo);
            JSONArray results = (JSONArray) entireJSON.get("results");
            con.disconnect();
            br.close();
            pmDAO.removeAll();
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
                String posterPath = "";
                String runtime = "";
                String status = "";
                String overview = "";
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
                
                PlayingMovie pm = new PlayingMovie(title, "0", releaseDate, runtime, overview, homepage, posterPath, imdbID, status, 0, trailerPath, videoPaths, imagePaths);
                //find if this genre already exists
                Genre gen = gDAO.findGenre(genre);
                
                if(genre == null) {
                    gen = gDAO.findGenre("none");
                    if(gen == null) {
                        gen = new Genre("none");
                        gDAO.create(gen);
                    }
                    
                }
                else if(gen == null) {
                    gen = new Genre(genre);
                    gDAO.create(gen);
                    
                }
                
                String movieTitle = title;
                movieTitle = movieTitle.replaceAll("'", "''");
                pm.setGenre(gen);
                
                pmDAO.create(pm);
                PlayingMovie pm2 = pmDAO.findMovie(movieTitle);
                if(pm2 != null) {
                    gen.getPlayingMovieSet().add(pm);
                }
                gDAO.edit(gen);
                
                con2.disconnect();
                br2.close();
            }
        } catch(Exception ex) {
            System.out.println(ex.getStackTrace());
        }
        System.out.println("Finished updating");
    }
}
