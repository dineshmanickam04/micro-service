package com.application.student.service;

import com.application.student.DTO.Department;
import com.application.student.repository.DepartmentClient;
import com.application.student.entity.Student;
import com.application.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    private final DepartmentClient departmentClient;

    @Autowired
    private StudentRepository studentRepository;

    public StudentService(DepartmentClient departmentClient) {
        this.departmentClient = departmentClient;
    }


    public Student addStudent(Student student) {

        return studentRepository.save(student);
    }

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public String deleteStudentById(Long id) {
    Optional<Student> findStudent = studentRepository.findById(id);
        if(findStudent.isPresent()) {
        studentRepository.deleteById(id);
        return "Student data deleted successfully";
    }
                return "school data not found";
}

    public String updateStudentById(Long id, Student updatedStudent) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();

         existingStudent.setName(updatedStudent.getName());
         existingStudent.setPlace(updatedStudent.getPlace());
         existingStudent.setMobileNo(updatedStudent.getMobileNo());


            studentRepository.save(existingStudent);
            return "Student data updated successfully";
        } else {
            return "Student with ID " + id + " not found";
        }
    }


    public Student getStudentById(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {


            Student student = optionalStudent.get();

            Department department = departmentClient.getData(student.getDepartment());

            student.setDepartment(department.getName());
            return student;
        } else {
            return null;
        }
    }

}
