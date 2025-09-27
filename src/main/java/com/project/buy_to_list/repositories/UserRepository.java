package com.project.buy_to_list.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.buy_to_list.domain.user.User;

public interface UserRepository extends JpaRepository<User, UUID>{

}
