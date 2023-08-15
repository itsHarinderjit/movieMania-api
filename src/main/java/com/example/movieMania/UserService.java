package com.example.movieMania;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public Optional<User> getUserByUserName(String userName) {
        return userRepository.findUserByUserName(userName);
    }

    public boolean addMovieInWishlist(String userName,String imdbId) {
        Optional<Movie> opmovie = movieRepository.findMovieByImdbId(imdbId);
        Movie movie = null;
        if (opmovie.isPresent())
            movie = opmovie.get();
        else
            return false;
        mongoTemplate.update(User.class)
                .matching(Criteria.where("userName").is(userName))
                .apply(new Update().push("wishlist").value(movie))
                .first();
        return true;
    }
}
