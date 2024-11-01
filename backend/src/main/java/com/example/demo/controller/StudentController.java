package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import com.example.demo.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(new ApiResponse<>(true, students));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getStudentById(@PathVariable("id") Integer studentId) {
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            return ResponseEntity.ok(new ApiResponse<>(true, student));
        } else {
            return ResponseEntity.ok(new ApiResponse<>(false, null));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> createStudent(@RequestBody Student student) {
        int result = studentService.createStudent(student);
        if (result > 0) {
            return ResponseEntity.ok(new ApiResponse<>(true, student));
        } else {
            return ResponseEntity.ok(new ApiResponse<>(false, null));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> updateStudent(@PathVariable("id") Integer studentId, @RequestBody Student student) {
        student.setStudentId(studentId);
        int result = studentService.updateStudent(student);
        if (result > 0) {
            return ResponseEntity.ok(new ApiResponse<>(true, student));
        } else {
            return ResponseEntity.ok(new ApiResponse<>(false, null));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteStudent(@PathVariable("id") Integer studentId) {
        int result = studentService.deleteStudent(studentId);
        if (result > 0) {
            return ResponseEntity.ok(new ApiResponse<>(true, null));
        } else {
            return ResponseEntity.ok(new ApiResponse<>(false, null));
        }
    }
}
