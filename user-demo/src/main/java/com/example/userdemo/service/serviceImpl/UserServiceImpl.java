package com.example.userdemo.service.serviceImpl;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.userdemo.ValueObject.Department;
import com.example.userdemo.ValueObject.ResponseTemplateObject;
import com.example.userdemo.entity.UserEntity;
import com.example.userdemo.repository.UserRepository;
import com.example.userdemo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
 	@Override
	public UserEntity addUser(UserEntity user) {
		return userRepository.save(user);
	}

	@Override
	public ResponseTemplateObject getUser(int id) {
		ResponseTemplateObject obj=new ResponseTemplateObject();
		Optional<UserEntity> user=userRepository.findById(id);
		UserEntity savedUser=new UserEntity();
		if(user.isPresent()) {
			savedUser=user.get();
		}
		
		Department department=restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+savedUser.getDepartmentId(), Department.class);
		
		obj.setUser(savedUser);
		obj.setDepartment(department);
		
		return obj;
		
	}

}

