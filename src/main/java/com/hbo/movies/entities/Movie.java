package com.hbo.movies.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Houssem BOUALI
 * date: 23/12/2021
 */
@Getter
@Setter
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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
    @JsonIgnore
    private MovieList movieList;
}
