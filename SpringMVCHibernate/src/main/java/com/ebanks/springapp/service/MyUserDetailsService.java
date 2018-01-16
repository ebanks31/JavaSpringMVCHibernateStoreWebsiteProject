package com.ebanks.springapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebanks.springapp.model.User;

/**
 * The Class MyUserDetailsService.
 */
@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    /** The user service. */
    @Autowired
    private UserService userService;

    /**
     * Loads user by username(e-mail)
     *
     * @param the email
     */
    public UserDetails loadUserByUsername(String email)
      throws UsernameNotFoundException {

        User user = userService.getUserByUserName(email);

        if (user == null) {
            throw new UsernameNotFoundException(
              "No user found with username: "+ email);
        }
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        //Returns a user with valid security credentials.
        return  new org.springframework.security.core.userdetails.User
          (user.getEmail(),
          user.getPassword().toLowerCase(), enabled, accountNonExpired,
          credentialsNonExpired, accountNonLocked,
          getAuthorities(user.getRoles()));
    }

    /**
     * Gets the authorities from a list of roles.
     *
     * @param roles the roles
     * @return the authorities
     */
    private static List<GrantedAuthority> getAuthorities (List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}