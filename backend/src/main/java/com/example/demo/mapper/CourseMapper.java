package com.example.demo.mapper;

import com.example.demo.model.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseMapper {

    @Select("SELECT * FROM courses")
    List<Course> findAll();

    @Select("SELECT * FROM courses WHERE CourseID = #{courseId}")
    Course findById(Integer courseId);

    @Insert("INSERT INTO courses (CourseID, CourseName) VALUES (#{courseId}, #{courseName})")
    @Options(useGeneratedKeys = true, keyProperty = "courseId")
    int insert(Course course);

    @Update("UPDATE courses SET CourseName = #{courseName} WHERE CourseID = #{courseId}")
    int update(Course course);

    @Delete("DELETE FROM courses WHERE CourseID = #{courseId}")
    int delete(Integer courseId);
}
