package com.hbo.movies.repositories;

import com.hbo.movies.entities.MovieList;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Houssem BOUALI
 * date: 24/12/2021
 */
public interface MovieListRepository extends JpaRepository<MovieList, Long> {
}
