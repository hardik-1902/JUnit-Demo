package com.Junittestdemo.Junittestdemo.controller;

import com.Junittestdemo.Junittestdemo.entity.UserEntity;
import com.Junittestdemo.Junittestdemo.entity.UserEntityDto;
import com.Junittestdemo.Junittestdemo.service.USerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    USerService uSerService;

    @PostMapping("/saveUser")
    public CompletableFuture<String> saveUser(@RequestBody UserEntityDto userEntityDto) {
        return uSerService.saveUser(userEntityDto);
    }

    @GetMapping("/getUser")
    public CompletableFuture<List<UserEntityDto>> getUser(@RequestParam(value = "name") String name) {
        return uSerService.getUser(name);
    }
}
