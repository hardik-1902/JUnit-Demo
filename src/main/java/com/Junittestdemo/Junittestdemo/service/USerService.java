package com.Junittestdemo.Junittestdemo.service;

import com.Junittestdemo.Junittestdemo.entity.UserEntity;
import com.Junittestdemo.Junittestdemo.entity.UserEntityDto;

import java.util.concurrent.CompletableFuture;

public interface USerService {
    public CompletableFuture<String> saveUser(UserEntityDto userEntityDto);

    public CompletableFuture<UserEntityDto> getUser(String name);
}
