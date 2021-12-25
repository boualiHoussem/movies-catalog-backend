package com.hbo.movies.services.impl;

import com.hbo.movies.entities.Movie;
import com.hbo.movies.repositories.MovieRepository;
import com.hbo.movies.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * @author Houssem BOUALI
 * date: 24/12/2021
 */
@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public Movie findMovieByTitle(String title) {
        return movieRepository.findByTitle(title).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void saveOrUpdate(Movie object) {
        this.movieRepository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        this.movieRepository.deleteById(id);
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }
}
