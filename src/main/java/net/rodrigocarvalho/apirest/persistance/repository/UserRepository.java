package net.rodrigocarvalho.apirest.persistance.repository;

import net.rodrigocarvalho.apirest.persistance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
