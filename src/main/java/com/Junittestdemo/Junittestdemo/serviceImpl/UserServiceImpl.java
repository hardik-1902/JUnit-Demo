package com.Junittestdemo.Junittestdemo.serviceImpl;

import com.Junittestdemo.Junittestdemo.entity.UserEntity;
import com.Junittestdemo.Junittestdemo.entity.UserEntityDto;
import com.Junittestdemo.Junittestdemo.repository.UserRepository;
import com.Junittestdemo.Junittestdemo.service.USerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    public CompletableFuture<List<UserEntityDto>> getUser(String name) {
        List<UserEntityDto> userEntityDto = new ArrayList<>();
        try {
            List<UserEntity> userEntity = userRepository.getUser(name);
            if(!userEntity.isEmpty()){
                for (UserEntity user : userEntity){
                    UserEntityDto entityDto = new UserEntityDto();
                    entityDto.setName(user.getName());
                    entityDto.setEmail(user.getEmail());
                    entityDto.setAge(user.getAge());
                    userEntityDto.add(entityDto);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return CompletableFuture.completedFuture(userEntityDto);
    }
}
