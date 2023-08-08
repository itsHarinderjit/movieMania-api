package com.example.movieMania;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // to know this is the service class
public class MovieService {
    @Autowired  // we want the framework to initialize the MovieRepository for us
    private MovieRepository movieRepository;
    public List<Movie> getAllMovies() {
        return movieRepository.findAll(); // predefined function to return a list of all documents of collection in mongoDB
//        return
    }

    public Optional<Movie> getMovieById(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId); // returns optional because there may be no movie with this id
    }
}
