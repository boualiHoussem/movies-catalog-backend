package com.hbo.movies.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author Houssem BOUALI
 * date: 23/12/2021
 */
@Data
@Entity
public class MovieList {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String type; // Wishlist | Favorites
    @OneToMany(mappedBy = "movieList")
    private List<Movie> movies;
    @ManyToOne
    private User user;

}
