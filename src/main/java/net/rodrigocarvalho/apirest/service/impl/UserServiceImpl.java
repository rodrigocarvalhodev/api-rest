package net.rodrigocarvalho.apirest.service.impl;

import net.rodrigocarvalho.apirest.model.request.UserRequest;
import net.rodrigocarvalho.apirest.model.response.UserResponse;
import net.rodrigocarvalho.apirest.persistance.entity.User;
import net.rodrigocarvalho.apirest.persistance.repository.UserRepository;
import net.rodrigocarvalho.apirest.service.Mapper;
import net.rodrigocarvalho.apirest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private Mapper<UserRequest, User> userRequestMapper;

    @Autowired
    private Mapper<User, UserResponse> userResponseMapper;

    @Override
    public UserResponse create(UserRequest request) {
        User user = userRequestMapper.map(request);
        return repository.saveAndFlush(user).map(userResponseMapper::map);
    }

    @Override
    public Page<UserResponse> getAll(Pageable pageable) {
        return repository.findAll(pageable).map(userResponseMapper::map);
    }

    @Override
    public Optional<UserResponse> get(Long id) {
        return repository.findById(id).map(userResponseMapper::map);
    }

    @Override
    public Optional<UserResponse> update(Long id, UserRequest request) {
        User updateUser = this.userRequestMapper.map(request);
        return repository.findById(id)
                .map(user -> {
                    user.setName(updateUser.getName());
                    user.setEmail(updateUser.getEmail());
                    return this.userResponseMapper.map(user);
                });
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}