package com.hbo.movies.repositories;

import com.hbo.movies.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Houssem BOUALI
 * date: 24/12/2021
 */
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findByTitle(String title);
}
