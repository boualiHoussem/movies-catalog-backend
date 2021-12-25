package com.hbo.movies.services;

import com.hbo.movies.entities.Movie;

/**
 * @author Houssem BOUALI
 * date: 24/12/2021
 */
public interface MovieService extends GenericService<Movie> {

    Movie findMovieByTitle(String title);
}
