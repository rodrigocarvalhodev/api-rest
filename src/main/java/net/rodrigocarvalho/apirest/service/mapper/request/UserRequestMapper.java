package net.rodrigocarvalho.apirest.service.mapper.request;

import net.rodrigocarvalho.apirest.model.request.UserRequest;
import net.rodrigocarvalho.apirest.persistance.entity.User;
import net.rodrigocarvalho.apirest.service.Mapper;
import org.springframework.stereotype.Component;

@Component
public class UserRequestMapper implements Mapper<UserRequest, User> {

    @Override
    public User map(UserRequest input) {
        if (input == null) return null;

        User user = new User();
        user.setName(input.getName());
        user.setEmail(input.getName());

        return user;
    }
}
