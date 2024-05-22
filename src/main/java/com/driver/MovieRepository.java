package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {

    private HashMap<String, Movie> movieMap;
    private HashMap<String, Director> directorMap;
    private HashMap<String, List<String>> directorMovieMapping;

    public MovieRepository(){
        this.movieMap = new HashMap<String, Movie>();
        this.directorMap = new HashMap<String, Director>();
        this.directorMovieMapping = new HashMap<String, List<String>>();
    }

    public void saveMovie(Movie movie){
        String name = movie.getName();
        movieMap.put(name, movie);
    }

    public void saveDirector(Director director){
        String dirName = director.getName();
        directorMap.put(dirName, director);
    }

    public void saveMovieDirectorPair(String movie, String director){
        if (movieMap.containsKey(movie) && directorMap.containsKey(director)){
            List<String> currMovies = new ArrayList<>();
            if(directorMovieMapping.containsKey(director)) {
                currMovies = directorMovieMapping.get(director);
            }
            currMovies.add(movie);
            directorMovieMapping.put(director, currMovies);
        }
    }

    public Movie findMovie(String movie){
        return movieMap.get(movie);
    }

    public Director findDirector(String director) {
        return directorMap.get(director);
    }

    public List<String> findMoviesFromDirector(String director) {
//        return directorMovieMapping.get(director);
        List<String> moviesList = new ArrayList<>();
        if(directorMovieMapping.containsKey(director)) {
            moviesList = directorMovieMapping.get(director);
        }
        return moviesList;
    }

    public List<String> findAllMovies(){
        return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirector(String director){
        List<String> movies = new ArrayList<>();
        if(directorMovieMapping.containsKey(director)){
            movies = directorMovieMapping.get(director);
            for(String movie: movies) {
                if(movieMap.containsKey(movie)){
                    movieMap.remove(movie);
                }
            }
            directorMovieMapping.remove(director);
        }
        if(directorMap.containsKey(director)) {
            directorMap.remove(director);
        }
    }

    public void deleteAllDirector(){
        HashSet<String> movieSet = new HashSet<>();
        for(String director: directorMovieMapping.keySet()){
            for(String movie: directorMovieMapping.get(director)) {
                movieSet.add(movie);
            }
        }

        for(String movie: movieSet){
            if(movieMap.containsKey(movie)) {
                movieMap.remove(movie);
            }
        }
    }

    public String getDirectorOfMovie(String movie){
        HashSet<String> movieSet = new HashSet<>();
        for(String director : directorMovieMapping.keySet()) {
            if(directorMovieMapping.get(director).contains(movie)){
                return director;
            }
        }
        return "No Such Movie Found";
    }
}