package com.Junittestdemo.Junittestdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Junittestdemo.Junittestdemo.entity.UserEntityDto;
import com.Junittestdemo.Junittestdemo.service.USerService;

@SpringBootTest
class JunittestdemoApplicationTests {

    @Autowired
    USerService uSerService;

    @Test
    void contextLoads() {
    }

    @Test
    public void saveUSerData() throws ExecutionException, InterruptedException {
        CompletableFuture<String> stringCompletableFuture = new CompletableFuture<>();
        UserEntityDto userEntityDto = new UserEntityDto();
        userEntityDto.setAge(22);
        userEntityDto.setEmail("hardik@gmail.com");
        userEntityDto.setName("hardik");
        stringCompletableFuture = uSerService.saveUser(userEntityDto);
        assertEquals("Save Data Sucessfully", stringCompletableFuture.get());
    }

    @Test
    public void getUserData() throws ExecutionException, InterruptedException {
        CompletableFuture<UserEntityDto> stringCompletableFuture = new CompletableFuture<>();
        UserEntityDto userEntityDto = new UserEntityDto();
        userEntityDto.setAge(22);
        userEntityDto.setEmail("hardik@gmail.com");
        userEntityDto.setName("hardik");
        stringCompletableFuture = uSerService.getUser("hardik");
        assertEquals(userEntityDto, stringCompletableFuture.get());
    }

}
