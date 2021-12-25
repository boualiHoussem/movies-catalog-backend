package com.hbo.movies.controllers;

import com.hbo.movies.entities.Movie;
import com.hbo.movies.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Houssem BOUALI
 * date: 24/12/2021
 */
@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/")
    public ResponseEntity<Void> addMovie(@RequestBody Movie movie) {
        this.movieService.saveOrUpdate(movie);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/")
    public ResponseEntity<Void> updateMovie(@RequestBody Movie movie) {
        this.movieService.saveOrUpdate(movie);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable("id") Long id) {
        this.movieService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{title}")
    public ResponseEntity<Movie> findByName(@PathVariable("title") String title) {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.movieService.findMovieByTitle(title)
        );
    }

    @GetMapping("/")
    public ResponseEntity<List<Movie>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.movieService.findAll()
        );
    }
}
