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
            List<String> movies = directorMovieMapping.getOrDefault(director, new ArrayList<>());
            movies.add(movie);
            directorMovieMapping.put(director, movies);
        }
    }

    public Movie findMovie(String movie){
        return movieMap.get(movie);
    }

    public Director findDirector(String director) {
        return directorMap.get(director);
    }

    public List<String> findMoviesFromDirector(String director) {
        return directorMovieMapping.get(director);
    }

    public List<String> findAllMovies(){
        return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirector(String director){
        directorMap.remove(director);
    }

    public void deleteAllDirector(){
        directorMap.clear();
    }
}