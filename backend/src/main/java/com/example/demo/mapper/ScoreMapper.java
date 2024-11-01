package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;

@Mapper
public interface ScoreMapper {
    @Select("SELECT \n" +
            "    s.StudentID, \n" +
            "    s.Name AS studentName, \n" +
            "    c.CourseName, \n" +
            "    g.Score\n" +
            "FROM \n" +
            "    students s\n" +
            "LEFT JOIN grades g ON s.StudentID = g.StudentID " +
            "LEFT JOIN courses c ON g.CourseID = c.CourseID;" )//左表有右表没有时，显示左表数据，右表数据为空
    List<Map<String, Object>> getStudentScoresWithTotal();

    @Select("SELECT " +
            "c.ClassID, " +
            "c.ClassName, " +
            "COUNT(s.StudentID) AS totalStudents, " +
            "COUNT(CASE WHEN g.Score >= 60 THEN 1 END) AS passingStudents, " +
            "AVG(g.Score) AS averageScore, " +
            "(COUNT(CASE WHEN g.Score >= 60 THEN 1 END) * 100.0 / COUNT(s.StudentID)) AS passingRate " +
            "FROM classes c " +
            "LEFT JOIN students s ON c.ClassID = s.ClassID " +
            "LEFT JOIN grades g ON s.StudentID = g.StudentID " +
            "GROUP BY c.ClassID, c.ClassName " +
            "ORDER BY c.ClassID")
    List<Map<String, Object>> getClassStatistics();
} 