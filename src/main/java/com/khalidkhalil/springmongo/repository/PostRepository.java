package com.khalidkhalil.springmongo.repository;

import com.khalidkhalil.springmongo.domain.Post;
import com.khalidkhalil.springmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ \"<field>\": { \"$regex\": ?0, \"$options\": \"<options>\" } }")
    List<Post> searchTitle(String text);

    List<Post> findByTitleContainingIgnoreCase(String text);
}
