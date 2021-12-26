package com.hbo.movies.common;

import com.hbo.movies.entities.User;
import com.hbo.movies.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * @author Houssem BOUALI
 * date: 26/12/2021
 */
@Component
@RequiredArgsConstructor
public class CommonUtils {

    private final UserRepository userRepository;

    public User getConnectedUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userDetails != null) {
            return userRepository.findByUsername(userDetails.getUsername()).orElse(null);
        }
        return null;
    }
}
