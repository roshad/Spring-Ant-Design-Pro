package com.example.demo.controller;

import com.example.demo.model.Grade;
import com.example.demo.service.GradeService;
import com.example.demo.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grades")
public class GradeController {

    private final GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Grade>>> getAllGrades() {
        List<Grade> grades = gradeService.getAllGrades();
        return ResponseEntity.ok(new ApiResponse<>(true, grades));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Grade>> getGradeById(@PathVariable("id") Integer gradeId) {
        Grade grade = gradeService.getGradeById(gradeId);
        if (grade != null) {
            return ResponseEntity.ok(new ApiResponse<>(true, grade));
        } else {
            return ResponseEntity.ok(new ApiResponse<>(false, null));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Grade>> createGrade(@RequestBody Grade grade) {
        int result = gradeService.createGrade(grade);
        if (result > 0) {
            return ResponseEntity.ok(new ApiResponse<>(true, grade));
        } else {
            return ResponseEntity.ok(new ApiResponse<>(false, null));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Grade>> updateGrade(@PathVariable("id") Integer gradeId, @RequestBody Grade grade) {
        grade.setGradeId(gradeId);
        int result = gradeService.updateGrade(grade);
        if (result > 0) {
            return ResponseEntity.ok(new ApiResponse<>(true, grade));
        } else {
            return ResponseEntity.ok(new ApiResponse<>(false, null));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteGrade(@PathVariable("id") Integer gradeId) {
        int result = gradeService.deleteGrade(gradeId);
        if (result > 0) {
            return ResponseEntity.ok(new ApiResponse<>(true, null));
        } else {
            return ResponseEntity.ok(new ApiResponse<>(false, null));
        }
    }
}
