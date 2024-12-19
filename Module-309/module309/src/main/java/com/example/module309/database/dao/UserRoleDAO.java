package com.example.module309.database.dao;

import com.example.module309.database.entity.User;
import com.example.module309.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleDAO extends JpaRepository<UserRole, Long> {

    UserRole findById(Integer id);

    List<UserRole> findByUserId(Integer userId);

}
