package com.packt.cardatabase;

import static java.util.Collections.emptyList;

import com.packt.cardatabase.service.JwtService;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@RequiredArgsConstructor
public class AuthenticationFilter extends OncePerRequestFilter {

  private final JwtService jwtService;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    String jws = request.getHeader(HttpHeaders.AUTHORIZATION);

    if(jws != null) {
      String user = jwtService.getAuthUser(request);

      Authentication authentication = new UsernamePasswordAuthenticationToken(
          user, null, emptyList());

      SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    filterChain.doFilter(request,response);
  }
}
