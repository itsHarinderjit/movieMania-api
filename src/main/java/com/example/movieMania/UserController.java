package com.example.movieMania;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.Optional;

@RestController
//@RequestMapping(path = "api/v1/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(path = "api/v1/user")
    public ResponseEntity<Optional<User>> getUser(@RequestBody Map<String,String> payload) {
        String userName = payload.get("userName");
        String password = payload.get("password");
        Optional<User> user = userService.getUserByUserName(userName);
        User thisUser;
        if(user.isPresent()) {
            thisUser = user.get();
            if (!thisUser.getPassword().equals(password)) {
                throw new ResponseStatusException(
                        HttpStatus.NOT_ACCEPTABLE, "Wrong password"
                );
            }
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"User not found"
            );
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(path = "/api/v1/user/addMovie")
    public ResponseEntity<Boolean> addMovieToWishlist(@RequestBody Map<String,String> payload) {
        return new ResponseEntity<>(userService.addMovieInWishlist(payload.get("userName"),payload.get("imdbId")),HttpStatus.OK);
    }
}
