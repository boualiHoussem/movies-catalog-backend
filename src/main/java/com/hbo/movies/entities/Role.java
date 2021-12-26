package com.hbo.movies.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Houssem BOUALI
 * date: 24/12/2021
 */
@Getter
@Setter
@Entity
public class Role {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
