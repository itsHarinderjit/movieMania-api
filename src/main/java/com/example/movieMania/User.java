package com.example.movieMania;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {
    @Id
    private ObjectId id;
    private String userName;
    private String password;
    @DocumentReference
    private List<Movie> watchlist;

    public User(String userName,String password,List<Movie> watchlist) {
        this.userName = userName;
        this.password = password;
        this.watchlist = watchlist;
    }
}
