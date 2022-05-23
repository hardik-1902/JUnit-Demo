package com.Junittestdemo.Junittestdemo.entity;

import java.io.Serializable;
import java.util.Objects;

public class UserEntityDto implements Serializable {
    private  String name;
    private  Integer age;
    private  String email;

    public UserEntityDto(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    public UserEntityDto() {

    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntityDto entity = (UserEntityDto) o;
        return Objects.equals(this.name, entity.name) &&
                Objects.equals(this.age, entity.age) &&
                Objects.equals(this.email, entity.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, email);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "name = " + name + ", " +
                "age = " + age + ", " +
                "email = " + email + ")";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
