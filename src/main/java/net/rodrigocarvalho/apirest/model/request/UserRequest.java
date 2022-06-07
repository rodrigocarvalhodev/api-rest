package net.rodrigocarvalho.apirest.model.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class UserRequest {

    @NotEmpty
    private String name;

    @NotEmpty
    @Email
    private String email;

}
