package com.example.demo.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Grade {
    private Integer gradeId;
    private Integer studentId;
    private Integer courseId;
    private BigDecimal score;
}
