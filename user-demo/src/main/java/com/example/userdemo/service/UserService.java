package com.example.userdemo.service;

import com.example.userdemo.ValueObject.ResponseTemplateObject;
import com.example.userdemo.entity.UserEntity;

public interface UserService {

	UserEntity addUser(UserEntity user);

	ResponseTemplateObject getUser(int id);

}
