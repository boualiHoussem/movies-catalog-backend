package com.hbo.movies.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Houssem BOUALI
 * date: 23/12/2021
 */
@Getter
@Setter
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class MovieList {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String type; // Wishlist | Favorites
    @OneToMany(mappedBy = "movieList")
    private List<Movie> movies = new ArrayList<>();
    @JsonIgnore
    @ManyToOne
    private User user;

}
