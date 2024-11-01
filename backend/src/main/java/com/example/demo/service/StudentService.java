package com.example.demo.service;

import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentMapper studentMapper;

    @Autowired
    public StudentService(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public List<Student> getAllStudents() {
        return studentMapper.findAll();
    }

    public Student getStudentById(Integer studentId) {
        return studentMapper.findById(studentId);
    }

    public int createStudent(Student student) {
        return studentMapper.insert(student);
    }

    public int updateStudent(Student student) {
        return studentMapper.update(student);
    }

    public int deleteStudent(Integer studentId) {
        return studentMapper.delete(studentId);
    }
}
