package com.cinexpress.videofriend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinexpress.videofriend.models.Movie;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByGenero(String genero);
    List<Movie> findByLanguage(String language);
    List<Movie> findByYear(int year);
    List<Movie> findByActoresContaining(String actor);
    List<Movie> findByDirector(String director);
}
