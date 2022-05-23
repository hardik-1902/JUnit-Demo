package com.Junittestdemo.Junittestdemo.serviceImpl;

import com.Junittestdemo.Junittestdemo.entity.UserEntity;
import com.Junittestdemo.Junittestdemo.entity.UserEntityDto;
import com.Junittestdemo.Junittestdemo.repository.UserRepository;
import com.Junittestdemo.Junittestdemo.service.USerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class UserServiceImpl implements USerService {

    @Autowired
    UserRepository userRepository;

    @Override
    public CompletableFuture<String> saveUser(UserEntityDto userEntityDto) {

        String s = null;
        try {

            UserEntity userEntity = new UserEntity();
            userEntity.setAge(userEntityDto.getAge());
            userEntity.setEmail(userEntityDto.getEmail());
            userEntity.setName(userEntityDto.getName());

            CompletableFuture<UserEntity> saveData = CompletableFuture.supplyAsync(() -> userRepository.save(userEntity));
            if (saveData.get() != null) {
                s = "Save Data Sucessfully";
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return CompletableFuture.completedFuture(s);
    }

    @Override
    public CompletableFuture<UserEntityDto> getUser(String name) {
        UserEntityDto userEntityDto = new UserEntityDto();
        try {
            Optional<UserEntity> userEntity = userRepository.getUser(name);
            if (userEntity.isPresent()) {
                userEntityDto.setName(userEntity.get().getName());
                userEntityDto.setEmail(userEntity.get().getEmail());
                userEntityDto.setAge(userEntity.get().getAge());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return CompletableFuture.completedFuture(userEntityDto);
    }
}
