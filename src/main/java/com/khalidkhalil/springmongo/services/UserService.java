package com.khalidkhalil.springmongo.services;

import com.khalidkhalil.springmongo.domain.User;
import com.khalidkhalil.springmongo.repository.UserRepository;
import com.khalidkhalil.springmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }
}
