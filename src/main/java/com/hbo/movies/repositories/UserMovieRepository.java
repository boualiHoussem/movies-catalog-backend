package com.hbo.movies.repositories;

import com.hbo.movies.entities.UserMovie;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Houssem BOUALI
 * date: 24/12/2021
 */
public interface UserMovieRepository extends JpaRepository<UserMovie, Long> {
}
