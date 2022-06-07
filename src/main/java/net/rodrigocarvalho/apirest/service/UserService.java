package net.rodrigocarvalho.apirest.service;

import net.rodrigocarvalho.apirest.model.request.UserRequest;
import net.rodrigocarvalho.apirest.model.response.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    UserResponse create(UserRequest request);

    Page<UserResponse> getAll(Pageable pageable);

    Optional<UserResponse> get(Long id);

    Optional<UserResponse> update(Long id, UserRequest request);

    void delete(Long id);

}