package org.practice.project.repository;

import java.util.Optional;

import org.practice.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>{
	Optional<User> findUserByEmail(String email);

}
