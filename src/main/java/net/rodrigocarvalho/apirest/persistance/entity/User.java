package net.rodrigocarvalho.apirest.persistance.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.function.Function;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    public <R> R map(Function<User, R> function) {
        return function.apply(this);
    }
}