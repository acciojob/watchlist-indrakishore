//package com.driver;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class MovieServiceTest {
//    @Mock
//    MovieRepository movieRepository;
//
//    @InjectMocks
//    MovieService movieService;
//
//    @Test
//    void addMovie() {
//        Movie movie = new Movie("Indra The Tiger", 200, 5);
//        movieService.addMovie(movie);
//        assertEquals(movieService.findMovie("Indra The Tiger"), movie);
//    }
//
//    @Test
//    void addDirector() {
//    }
//
//    @Test
//    void createMovieDirectorPair() {
//    }
//
//    @Test
//    void findMovie() {
//        when(movieRepository.findMovie(anyString())).thenReturn(new Movie("Indra The Tiger", 100, 10.5));
//        Movie movie = movieService.findMovie("Indra The Tiger");
//        assertEquals(movie.getName(), "Indra The Tiger");
//    }
//
//    @Test
//    void findDirector() {
//    }
//
//    @Test
//    void findMoviesFromDirector() {
//    }
//}