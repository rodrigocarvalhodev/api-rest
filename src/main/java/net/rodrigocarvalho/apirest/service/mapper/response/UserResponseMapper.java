package net.rodrigocarvalho.apirest.service.mapper.response;

import net.rodrigocarvalho.apirest.model.request.UserRequest;
import net.rodrigocarvalho.apirest.model.response.UserResponse;
import net.rodrigocarvalho.apirest.persistance.entity.User;
import net.rodrigocarvalho.apirest.service.Mapper;
import org.springframework.stereotype.Component;

@Component
public class UserResponseMapper implements Mapper<User, UserResponse> {

    @Override
    public UserResponse map(User input) {
        if (input == null) return null;
        UserResponse response = new UserResponse();
        response.setId(input.getId());
        response.setName(input.getName());
        response.setEmail(input.getEmail());
        return response;
    }
}
