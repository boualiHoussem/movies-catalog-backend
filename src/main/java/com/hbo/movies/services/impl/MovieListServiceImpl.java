package com.hbo.movies.services.impl;

import com.hbo.movies.entities.MovieList;
import com.hbo.movies.repositories.MovieListRepository;
import com.hbo.movies.services.MovieListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Houssem BOUALI
 * date: 24/12/2021
 */
@Service
@RequiredArgsConstructor
public class MovieListServiceImpl implements MovieListService {

    private final MovieListRepository movieListRepository;

    @Override
    public void saveOrUpdate(MovieList object) {
        movieListRepository.save(object);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public MovieList findById(Long id) {
        return null;
    }

    @Override
    public List<MovieList> findAll() {
        return null;
    }
}
