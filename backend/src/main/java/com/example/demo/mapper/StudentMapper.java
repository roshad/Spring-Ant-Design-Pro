package com.example.demo.mapper;

import com.example.demo.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM students")
    List<Student> findAll();

    @Select("SELECT * FROM students WHERE StudentID = #{studentId}")
    Student findById(Integer studentId);

    @Insert("INSERT INTO students (StudentId,Name, Gender, ClassID) VALUES (#{studentId},#{name}, #{gender}, #{classId})")
    @Options(useGeneratedKeys = true, keyProperty = "studentId")
    int insert(Student student);

    @Update("UPDATE students SET Name = #{name}, Gender = #{gender}, ClassID = #{classId} WHERE StudentID = #{studentId}")
    int update(Student student);

    @Delete("DELETE FROM students WHERE StudentID = #{studentId}")
    int delete(Integer studentId);
}
