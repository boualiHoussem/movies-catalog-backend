package com.hbo.movies.services.impl;

import com.hbo.movies.entities.Movie;
import com.hbo.movies.entities.MovieList;
import com.hbo.movies.entities.User;
import com.hbo.movies.entities.UserMovie;
import com.hbo.movies.repositories.UserRepository;
import com.hbo.movies.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Houssem BOUALI
 * date: 24/12/2021
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public void saveOrUpdate(User object) {
        userRepository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<Movie> findUserMovies(Long id) {
        List<Movie> result = new ArrayList<>();
        userRepository.findById(id)
                .ifPresent(user -> {
                    result.addAll(user.getUserMovies()
                            .stream()
                            .map(UserMovie::getMovie)
                            .collect(Collectors.toList()));
                });
        return result;
    }

    @Override
    public List<MovieList> findMovieLists(Long id) {
        List<MovieList> movieLists = new ArrayList<>();
        userRepository.findById(id)
                .ifPresent(user -> {
                    movieLists.addAll(user.getMovieList());
                });
        return movieLists;
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public boolean registerUser(User user) {
        if (user.getUsername() == null || user.getUsername().isEmpty()
                || user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new IllegalStateException();
        }
        if (!userRepository.findByUsername(user.getUsername()).isPresent()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            this.saveOrUpdate(user);
            return true;
        }
        return false;
    }
}
