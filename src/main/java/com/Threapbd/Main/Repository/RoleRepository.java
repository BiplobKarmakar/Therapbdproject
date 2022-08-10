package com.Threapbd.Main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Threapbd.Main.Entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
     @Query("SELECT r From Role r WHERE r.name=?1")
	public Role findByName(String name);
}
