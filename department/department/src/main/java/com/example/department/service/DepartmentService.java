package com.example.department.service;


import com.example.department.model.Department;
import com.example.department.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    public Department addData(Department department) {
        return departmentRepository.save(department);
    }

    public String removeData(Long id) {
        Optional<Department> findDepartment=departmentRepository.findById(id);
        if(findDepartment.isPresent()){
            departmentRepository.deleteById(id);
            return "Department data deleted successfully";
        }
        return "Department data not found";
    }

    public String updateData(Long id, Department department) {
        Optional<Department> findDepartment=departmentRepository.findById(id);
        if(findDepartment.isPresent()){
            Department data=findDepartment.get();
            data.setDepartmentName(department.getDepartmentName());
            departmentRepository.save(data);
            return "Department data updated successfully";
        }
        else {
            return "Department "+ id +"not found";
        }
    }

    public Department getData(Long id) {
        Optional<Department> department= departmentRepository.findById(id);
        return department.get();
    }
}
