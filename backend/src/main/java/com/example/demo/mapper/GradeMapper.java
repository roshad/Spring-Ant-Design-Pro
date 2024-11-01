package com.example.demo.mapper;

import com.example.demo.model.Grade;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GradeMapper {

    @Select("SELECT * FROM grades")
    List<Grade> findAll();

    @Select("SELECT * FROM grades WHERE GradeID = #{gradeId}")
    Grade findById(Integer gradeId);

    @Insert("INSERT INTO grades (StudentID, CourseID, Score) VALUES (#{studentId}, #{courseId}, #{score})")
    @Options(useGeneratedKeys = true, keyProperty = "gradeId")
    int insert(Grade grade);

    @Update("UPDATE grades SET StudentID = #{studentId}, CourseID = #{courseId}, Score = #{score} WHERE GradeID = #{gradeId}")
    int update(Grade grade);

    @Delete("DELETE FROM grades WHERE GradeID = #{gradeId}")
    int delete(Integer gradeId);
}
