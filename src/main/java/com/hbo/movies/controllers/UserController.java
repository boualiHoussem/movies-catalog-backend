package com.hbo.movies.controllers;

import com.hbo.movies.entities.Movie;
import com.hbo.movies.entities.MovieList;
import com.hbo.movies.entities.User;
import com.hbo.movies.services.UserService;
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
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/")
    public ResponseEntity<Void> addUser(@RequestBody User user) {
        this.userService.saveOrUpdate(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/")
    public ResponseEntity<Void> updateUser(@RequestBody User user) {
        this.userService.saveOrUpdate(user);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        this.userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}/movies")
    public ResponseEntity<List<Movie>> getUserMovies(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.userService.findUserMovies(id)
        );
    }

    @GetMapping("/{id}/movies-list")
    public ResponseEntity<List<MovieList>> getUserMovieList(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.userService.findMovieLists(id)
        );
    }

//    @GetMapping("/{id}/list/{type}")
//    public ResponseEntity<List<MovieList>> getMovieListByType(@PathVariable("id") Long id,
//                                                              @PathVariable("type") String type) {
//        return ResponseEntity.status(HttpStatus.OK).body(this.userService.findMovieListsByIdAndType(id, type));
//    }
}
