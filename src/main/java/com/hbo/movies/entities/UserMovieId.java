package com.hbo.movies.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Houssem BOUALI
 * date: 23/12/2021
 */
@Getter
@Setter
@Embeddable
public class UserMovieId implements Serializable {

    private Long userId;
    private Long movieId;
}
