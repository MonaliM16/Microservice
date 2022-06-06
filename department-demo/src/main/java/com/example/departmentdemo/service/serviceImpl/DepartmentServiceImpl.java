package com.example.departmentdemo.service.serviceImpl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.departmentdemo.entity.Department;
import com.example.departmentdemo.repository.DepartmentRepository;
import com.example.departmentdemo.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public Department getDepartment(int id) {
		Optional<Department> savedDepartment=departmentRepository.findById(id);
		Department dep=new Department();
		if(savedDepartment.isPresent()) {
			dep=savedDepartment.get();
		}
		return dep;
	}

}

