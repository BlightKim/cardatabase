package com.packt.cardatabase.service;

import com.packt.cardatabase.domain.User;
import com.packt.cardatabase.domain.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> user = userRepository.findByUsername(username);

    UserBuilder builder = null;
    if(user.isPresent()) {
      User currentUser = user.get();
      builder = org.springframework.security.core.userdetails.User.withUsername(username)
          .password(currentUser.getPassword())
          .roles(currentUser.getRole());
    } else {
      throw new UsernameNotFoundException("User not found");
    }

    return builder.build();
  }
}
