package com.example.demo.controller;

import com.example.demo.model.Class;
import com.example.demo.service.ClassService;
import com.example.demo.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClassController {

    private final ClassService classService;

    @Autowired
    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Class>>> getAllClasses() {
        List<Class> classes = classService.getAllClasses();
        return ResponseEntity.ok(new ApiResponse<>(true, classes));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Class>> getClassById(@PathVariable("id") Integer classId) {
        Class clazz = classService.getClassById(classId);
        if (clazz != null) {
            return ResponseEntity.ok(new ApiResponse<>(true, clazz));
        } else {
            return ResponseEntity.ok(new ApiResponse<>(false, null));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Class>> createClass(@RequestBody Class clazz) {
        int result = classService.createClass(clazz);
        if (result > 0) {
            return ResponseEntity.ok(new ApiResponse<>(true, clazz));
        } else {
            return ResponseEntity.ok(new ApiResponse<>(false, null));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Class>> updateClass(@PathVariable("id") Integer classId, @RequestBody Class clazz) {
        clazz.setClassId(classId);
        int result = classService.updateClass(clazz);
        if (result > 0) {
            return ResponseEntity.ok(new ApiResponse<>(true, clazz));
        } else {
            return ResponseEntity.ok(new ApiResponse<>(false, null));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteClass(@PathVariable("id") Integer classId) {
        int result = classService.deleteClass(classId);
        if (result > 0) {
            return ResponseEntity.ok(new ApiResponse<>(true, null));
        } else {
            return ResponseEntity.ok(new ApiResponse<>(false, null));
        }
    }
}
