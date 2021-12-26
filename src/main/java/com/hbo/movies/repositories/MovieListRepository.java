package com.hbo.movies.repositories;

import com.hbo.movies.entities.MovieList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Houssem BOUALI
 * date: 24/12/2021
 */
public interface MovieListRepository extends JpaRepository<MovieList, Long> {

    @Query("select ml from MovieList ml where ml.user.id = :id and ml.type = :type")
    MovieList findByUserIdAndType(@Param("id") Long id, @Param("type") String type);
}
