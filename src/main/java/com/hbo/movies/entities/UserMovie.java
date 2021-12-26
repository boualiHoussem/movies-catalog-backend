package com.hbo.movies.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 * @author Houssem BOUALI
 * date: 23/12/2021
 */
@Getter
@Setter
@Entity
public class UserMovie {

    @EmbeddedId
    private UserMovieId id;

    @ManyToOne
    @MapsId("userId")
    private User user;

    @ManyToOne
    @MapsId("movieId")
    private Movie movie;

    private int rating;
}
