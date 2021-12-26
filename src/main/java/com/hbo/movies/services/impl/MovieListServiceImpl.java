package com.hbo.movies.services.impl;

import com.hbo.movies.common.CommonUtils;
import com.hbo.movies.entities.MovieList;
import com.hbo.movies.entities.User;
import com.hbo.movies.repositories.MovieListRepository;
import com.hbo.movies.repositories.MovieRepository;
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
    private final MovieRepository movieRepository;
    private final CommonUtils commonUtils;

    @Override
    public void saveOrUpdate(MovieList object) {
        User connectedUser = commonUtils.getConnectedUser();
        object.setUser(connectedUser);
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

    @Override
    public MovieList findUserListByType(String type) {
        User connectedUser = commonUtils.getConnectedUser();
        return connectedUser != null ? movieListRepository.findByUserIdAndType(connectedUser.getId(), type) : null;
    }

    @Override
    public void addMovieToList(Long listId, Long movieId) {
        movieListRepository.findById(listId).ifPresent(
                list -> movieRepository.findById(movieId)
                        .ifPresent(movie -> {
                            movie.setMovieList(list);
                            movieRepository.save(movie);
                        })
        );
    }
}
