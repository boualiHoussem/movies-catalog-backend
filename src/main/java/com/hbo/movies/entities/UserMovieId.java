package com.hbo.movies.entities;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Houssem BOUALI
 * date: 23/12/2021
 */
@Data
@Embeddable
public class UserMovieId implements Serializable {

    private Long userId;
    private Long movieId;
}
