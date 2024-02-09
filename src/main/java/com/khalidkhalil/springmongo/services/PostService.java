package com.khalidkhalil.springmongo.services;

import com.khalidkhalil.springmongo.domain.Post;
import com.khalidkhalil.springmongo.domain.User;
import com.khalidkhalil.springmongo.dto.UserDTO;
import com.khalidkhalil.springmongo.repository.PostRepository;
import com.khalidkhalil.springmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;


    public Post findById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }



    public List<Post> findByTittle(String text) {
        return repo.findByTitleContainingIgnoreCase(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repo.fullSearch(text, minDate, maxDate);
    }
}
