package com.example.movieMania;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // to know this is the controller class
@RequestMapping("/api/v1/movies") // get the address at which this class will be used
@CrossOrigin(origins = "*") // to remove CORS policy error
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping  // for get operations from client side
    public ResponseEntity<List<Movie>> allMovies() {  // always send response in this way
        return new ResponseEntity<>(movieService.getAllMovies(),HttpStatus.OK);
    }

    @GetMapping(path = "/{id}") // it works for localhost:8080/api/v1/movies/{id of movie}
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable String id) { // it lets the framework know that id has value from path itself
        return new ResponseEntity<>(movieService.getMovieById(id),HttpStatus.OK);
    }
}
