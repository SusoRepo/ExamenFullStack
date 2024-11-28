package com.cinexpress.videofriend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinexpress.videofriend.models.Movie;
import com.cinexpress.videofriend.services.MovieService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("")
    public ResponseEntity<Void> createMovie(@RequestBody Movie movie) {
        try {
            movieService.createMovie(movie);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @PostMapping("/addMovieToInventory")
    public ResponseEntity<Void> addMovieToCompany (Long movieId, Long companyId) {
        try {
            movieService.addMovieToCompany(movieId, companyId);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @GetMapping("/listAllMovies")
    public ResponseEntity<List<Movie>> listAllMovies() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(movieService.listAllMovies());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @GetMapping("/findByGenero")
    public ResponseEntity<List<Movie>> listAllMoviesByGenreMovies(@RequestParam String genero) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(movieService.listAllMoviesByGenreMovies(genero));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @GetMapping("/findByLanguage")
    public ResponseEntity<List<Movie>> listAllMoviesByLanguage(@RequestParam String language) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(movieService.listAllMoviesByLanguage(language));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @GetMapping("/findByYear")
    public ResponseEntity<List<Movie>> listAllMoviesByYear(@RequestParam int year) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(movieService.listAllMoviesByYear(year));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @GetMapping("/findByActores")
    public ResponseEntity<List<Movie>> listAllMoviesByActores(@RequestParam String actor) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(movieService.listAllMoviesByActores(actor));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @GetMapping("/findByDirectors")
    public ResponseEntity<List<Movie>> listAllMoviesByDirectors(@RequestParam String director) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(movieService.listAllMoviesByDirectors(director));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
    
    
    

}
