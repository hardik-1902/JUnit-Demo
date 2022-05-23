package com.Junittestdemo.Junittestdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
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
        CompletableFuture<List<UserEntityDto>> stringCompletableFuture = new CompletableFuture<>();
        List<UserEntityDto> list = new ArrayList<>();
        list.add(new UserEntityDto("hardik",22,"hardik@gmail.com"));
        list.add(new UserEntityDto("hardik",23,"hardik23@gmail.com"));
        
        stringCompletableFuture = uSerService.getUser("hardik");
        assertEquals(list, stringCompletableFuture.get());
    }

}
