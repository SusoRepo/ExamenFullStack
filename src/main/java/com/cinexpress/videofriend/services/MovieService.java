package com.cinexpress.videofriend.services;

import java.util.List;

import com.cinexpress.videofriend.models.Movie;

public interface MovieService {
    void addMovie(Movie movie);
    void updateMovie(Movie move);
    void updateAvailability(Movie movie);
    void createMovie(Movie movie);
    List<Movie> listAllMovies();
    List<Movie> listAllMoviesByGenreMovies(String genero);
    List<Movie> listAllMoviesByLanguage(String language);
    List<Movie> listAllMoviesByYear(int year);
    List<Movie> listAllMoviesByActores(String actor);
    List<Movie> listAllMoviesByDirectors(String director);
    void addMovieToCompany(Long movieId, Long companyId);
}
