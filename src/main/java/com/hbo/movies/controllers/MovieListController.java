package com.hbo.movies.controllers;

import com.hbo.movies.entities.MovieList;
import com.hbo.movies.services.MovieListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Houssem BOUALI
 * date: 24/12/2021
 */
@RestController
@RequestMapping("/movies-lists")
@RequiredArgsConstructor
public class MovieListController {

    private final MovieListService movieListService;

    @PostMapping("/")
    public ResponseEntity<Void> addMovieList(@RequestBody MovieList movieList) {
        this.movieListService.saveOrUpdate(movieList);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{type}")
    public ResponseEntity<MovieList> getUserList(@PathVariable("type") String type) {
        return ResponseEntity.ok(this.movieListService.findUserListByType(type));
    }

    @PostMapping("/{listId}/movie/{movieId}")
    public ResponseEntity<Void> addMovieToList(@PathVariable("listId") Long listId, @PathVariable("movieId") Long movieId) {
        this.movieListService.addMovieToList(listId, movieId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
