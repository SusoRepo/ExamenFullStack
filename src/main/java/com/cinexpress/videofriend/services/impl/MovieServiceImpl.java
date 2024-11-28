package com.cinexpress.videofriend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinexpress.videofriend.models.Company;
import com.cinexpress.videofriend.models.Movie;
import com.cinexpress.videofriend.repository.CompanyRepository;
import com.cinexpress.videofriend.repository.MovieRepository;
import com.cinexpress.videofriend.services.MovieService;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    MovieRepository movieRepository;
    

    @Override
    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void updateMovie(Movie move) {
        movieRepository.save(move);
    }

    @Override
    public void updateAvailability(Movie movie) {
        if (movie.getAvailability() == true) {
            movie.setAvailability(false);
        } else {
            movie.setAvailability(true);
        }
    }

    @Override
    public void createMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public List<Movie> listAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> listAllMoviesByGenreMovies(String genero) {
        return movieRepository.findByGenero(genero);
    }

    @Override
    public List<Movie> listAllMoviesByLanguage(String language) {
        return movieRepository.findByLanguage(language);
    }

    @Override
    public List<Movie> listAllMoviesByYear(int year) {
        return movieRepository.findByYear(year);
    }

    @Override
    public List<Movie> listAllMoviesByActores(String actor) {
        return movieRepository.findByActoresContaining(actor);
    }

    @Override
    public List<Movie> listAllMoviesByDirectors(String director) {
        return movieRepository.findByDirector(director);
    }

    @Override
    public void addMovieToCompany(Long movieId, Long companyId) {
        Movie movie = movieRepository.findById(movieId).get();
        Company company = companyRepository.findById(companyId).get();
        movie.setCompany(company);
        movieRepository.save(movie);
        companyRepository.save(company);
    }


    
    
}
