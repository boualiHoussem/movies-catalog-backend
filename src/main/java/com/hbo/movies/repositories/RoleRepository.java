package com.hbo.movies.repositories;

import com.hbo.movies.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Houssem BOUALI
 * date: 24/12/2021
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
