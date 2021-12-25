package com.hbo.movies.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Houssem BOUALI
 * date: 23/12/2021
 */
@Data
@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @Lob
    private String description;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate releaseDate;
    private String genre;
    private String director;
    private String posterUrl;
    @OneToMany(mappedBy = "movie")
    private List<UserMovie> userMovies;
    @ManyToOne
    private MovieList movieList;
}
