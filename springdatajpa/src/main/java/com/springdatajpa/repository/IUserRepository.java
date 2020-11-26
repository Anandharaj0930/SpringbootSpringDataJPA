package com.springdatajpa.repository;

import com.springdatajpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
   User getByName(final String name);
}
