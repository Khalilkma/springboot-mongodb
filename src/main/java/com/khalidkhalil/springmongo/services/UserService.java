package com.khalidkhalil.springmongo.services;

import com.khalidkhalil.springmongo.domain.User;
import com.khalidkhalil.springmongo.dto.UserDTO;
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

    public User insert(User obj) {
        return repo.insert(obj);
    }

    public void delete(String id) {
        User userToDelete = findById(id);
        repo.delete(userToDelete);
    }

    public User update(User obj) {
        User existingUser = findById(obj.getId());
        updateData(existingUser, obj);
        return repo.save(existingUser);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
