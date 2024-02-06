package com.khalidkhalil.springmongo.repository;

import com.khalidkhalil.springmongo.domain.Post;
import com.khalidkhalil.springmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
