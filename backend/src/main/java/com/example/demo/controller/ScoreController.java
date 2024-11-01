package com.example.demo.controller;

import com.example.demo.mapper.ScoreMapper;
import com.example.demo.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/scores")
public class ScoreController {

    @Autowired
    private ScoreMapper scoreMapper;

    @GetMapping("/table")
    public ApiResponse<List<Map<String, Object>>> getStudentScoresTable() {
        List<Map<String, Object>> scores = scoreMapper.getStudentScoresWithTotal();

        // 创建一个 Map，用来存储按 StudentID 分组的成绩记录
        Map<Integer, Map<String, Object>> studentMap = new HashMap<>();

        for (Map<String, Object> score : scores) {
            Integer studentId = (Integer) score.get("StudentID");
            String courseName = ((String) score.get("CourseName")).toLowerCase();  // 课程名转换为小写
            double courseScore = ((Number) score.get("Score")).doubleValue(); // 转为浮点数 double是默认的，而且对性能影响小

            // 如果该学生还没有记录，先初始化
            studentMap.computeIfAbsent(studentId, k -> {
                Map<String, Object> studentRecord = new HashMap<>();
                studentRecord.put("StudentID", studentId);
                studentRecord.put("studentName", score.get("studentName"));
                studentRecord.put("total", 0.0);  // 初始化总分为浮点数
                return studentRecord;
            });

            // 获取该学生的记录
            Map<String, Object> studentRecord = studentMap.get(studentId);

            // 将课程成绩放入记录中
            studentRecord.put(courseName, courseScore);

            // 更新总分
            double totalScore = (double) studentRecord.get("total") + courseScore;
            studentRecord.put("total", totalScore);
        }

        // 转换为 List 格式
        List<Map<String, Object>> formattedScores = new ArrayList<>(studentMap.values());

        return new ApiResponse<>(true, formattedScores);
    }
    @GetMapping("/class-statistics")
    public ApiResponse<List<Map<String, Object>>> getClassStatistics() {
        List<Map<String, Object>> statistics = scoreMapper.getClassStatistics();
        return new ApiResponse<>(true, statistics);
    }
}
