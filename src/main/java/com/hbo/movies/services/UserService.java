package com.hbo.movies.services;

import com.hbo.movies.entities.Movie;
import com.hbo.movies.entities.MovieList;
import com.hbo.movies.entities.User;

import java.util.List;

/**
 * @author Houssem BOUALI
 * date: 24/12/2021
 */
public interface UserService extends GenericService<User> {

    List<Movie> findUserMovies(Long id);

    List<MovieList> findMovieLists(Long id);

    User findUserByUsername(String username);

    boolean registerUser(User user);
}
