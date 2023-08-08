package com.example.movieMania;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies") // to let program know that this is a class which will carry data from movies collection
@Data // to add all getters and setters
@AllArgsConstructor // to auto generate a constructor with all arguments
@NoArgsConstructor // to auto generate a constructor with no argument
public class Movie {
    @Id // to let code know that this attribute is the unique id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseData;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference // kind of foreign key
    private List<Review> reviewIds;
}
