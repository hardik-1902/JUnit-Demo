package com.Junittestdemo.Junittestdemo.repository;

import com.Junittestdemo.Junittestdemo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query("SELECT s FROM UserEntity s where s.name =:name")
    List<UserEntity> getUser(String name);
}