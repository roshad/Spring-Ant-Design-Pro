package com.example.demo.service;

import com.example.demo.mapper.CourseMapper;
import com.example.demo.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseMapper courseMapper;

    @Autowired
    public CourseService(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    public List<Course> getAllCourses() {
        return courseMapper.findAll();
    }

    public Course getCourseById(Integer courseId) {
        return courseMapper.findById(courseId);
    }

    public int createCourse(Course course) {
        return courseMapper.insert(course);
    }

    public int updateCourse(Course course) {
        return courseMapper.update(course);
    }

    public int deleteCourse(Integer courseId) {
        return courseMapper.delete(courseId);
    }
}
