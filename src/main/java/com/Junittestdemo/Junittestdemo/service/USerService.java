package com.Junittestdemo.Junittestdemo.service;

import com.Junittestdemo.Junittestdemo.entity.UserEntity;
import com.Junittestdemo.Junittestdemo.entity.UserEntityDto;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface USerService {
    public CompletableFuture<String> saveUser(UserEntityDto userEntityDto);

    public CompletableFuture<List<UserEntityDto>> getUser(String name);
}
