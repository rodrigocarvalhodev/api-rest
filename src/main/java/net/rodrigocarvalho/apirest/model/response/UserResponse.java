package net.rodrigocarvalho.apirest.model.response;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserResponse {

    @NotNull
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    @Email
    private String email;

}
