package dz.rgserver.controller;


import dz.rgserver.config.TokenProvider;
import dz.rgserver.model.AuthToken;
import dz.rgserver.model.LoginUser;
import dz.rgserver.model.Role;
import dz.rgserver.model.User;
import dz.rgserver.model.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import static dz.rgserver.model.Constants.TOKEN_PREFIX;

import java.util.Collection;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationRestService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserRestService userRestService;

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public AuthToken register(@RequestBody LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getEmail(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        final User user = userRestService.findOne(loginUser.getEmail());
        return new AuthToken(token, user.getEmail(), user.getRole().getName());
    }
    
 

}