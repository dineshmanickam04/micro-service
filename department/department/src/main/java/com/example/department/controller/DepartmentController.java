package com.example.department.controller;


import com.example.department.model.Department;
import com.example.department.repo.DepartmentRepository;
import com.example.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @Autowired
    private DepartmentRepository departmentRepository;


    @GetMapping("/get-all")
    public List<Department> getAll(){
        return departmentService.getAll();
    }

    @PostMapping("/add")
    public Department addData(@RequestBody Department department){
        return departmentService.addData(department);
    }
    @DeleteMapping("/remove-data/{id}")
    public String deleteData(@PathVariable Long id){
        return departmentService.removeData(id);
    }
    @PutMapping("/update-data/{id}")
    public ResponseEntity<String> updateData(@PathVariable Long id,@RequestBody Department department){
        String result=departmentService.updateData(id,department);
        if(result.contains("successfully")){
            return ResponseEntity.ok(result);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }
    @GetMapping("/get-data/{id}")
    public Department getData(@PathVariable Long id){
        return departmentService.getData(id);
    }

    @GetMapping("/get-data-by-name")
    public Department getData(@RequestParam String name){
        return departmentRepository.findByName(name);
    }



}
