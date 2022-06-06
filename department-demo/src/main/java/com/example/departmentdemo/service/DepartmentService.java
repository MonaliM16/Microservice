package com.example.departmentdemo.service;



import com.example.departmentdemo.entity.Department;

public interface DepartmentService {
	
	Department saveDepartment(Department department);
	Department getDepartment(int id);

}

