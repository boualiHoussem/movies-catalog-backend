package com.hbo.movies.services;

import com.hbo.movies.entities.MovieList;

/**
 * @author Houssem BOUALI
 * date: 24/12/2021
 */
public interface MovieListService extends GenericService<MovieList> {

    MovieList findUserListByType(String type);

    void addMovieToList(Long listId, Long movieId);
}
