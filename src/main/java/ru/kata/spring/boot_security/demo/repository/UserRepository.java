package ru.kata.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("Select u from User u join fetch u.roles where u.username=(:username)")
    User getUserByName(String username);

    User getUserById(Long id);

}
