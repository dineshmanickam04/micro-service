package com.application.student.repository;

import com.application.student.DTO.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentClient {

     @GetMapping("/department/get-data-by-name")
     Department getData(@RequestParam("name") String name);

}
