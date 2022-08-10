package com.Threapbd.Main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Threapbd.Main.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u from User u where u.email=?1")
	User findByEmail(String email);

}
