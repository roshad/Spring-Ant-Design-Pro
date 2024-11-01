package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.service.CourseService;
import com.example.demo.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Course>>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return ResponseEntity.ok(new ApiResponse<>(true, courses));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> getCourseById(@PathVariable("id") Integer courseId) {
        Course course = courseService.getCourseById(courseId);
        if (course != null) {
            return ResponseEntity.ok(new ApiResponse<>(true, course));
        } else {
            return ResponseEntity.ok(new ApiResponse<>(false, null));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Course>> createCourse(@RequestBody Course course) {
        int result = courseService.createCourse(course);
        if (result > 0) {
            return ResponseEntity.ok(new ApiResponse<>(true, course));
        } else {
            return ResponseEntity.ok(new ApiResponse<>(false, null));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> updateCourse(@PathVariable("id") Integer courseId, @RequestBody Course course) {
        course.setCourseId(courseId);
        int result = courseService.updateCourse(course);
        if (result > 0) {
            return ResponseEntity.ok(new ApiResponse<>(true, course));
        } else {
            return ResponseEntity.ok(new ApiResponse<>(false, null));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCourse(@PathVariable("id") Integer courseId) {
        int result = courseService.deleteCourse(courseId);
        if (result > 0) {
            return ResponseEntity.ok(new ApiResponse<>(true, null));
        } else {
            return ResponseEntity.ok(new ApiResponse<>(false, null));
        }
    }
}
