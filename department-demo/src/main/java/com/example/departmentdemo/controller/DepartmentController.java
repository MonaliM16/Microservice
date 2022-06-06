package com.example.departmentdemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.departmentdemo.entity.Department;
import com.example.departmentdemo.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/")
	public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
		return new ResponseEntity<Department>(departmentService.saveDepartment(department),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public Department getDepartmentById(@PathVariable int id) {
		return departmentService.getDepartment(id);
	}
}

