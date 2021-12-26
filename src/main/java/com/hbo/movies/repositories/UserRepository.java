package com.hbo.movies.repositories;

import com.hbo.movies.entities.MovieList;
import com.hbo.movies.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Houssem BOUALI
 * date: 24/12/2021
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
