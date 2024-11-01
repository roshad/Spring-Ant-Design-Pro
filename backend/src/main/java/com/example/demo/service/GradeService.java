package com.example.demo.service;

import com.example.demo.mapper.GradeMapper;
import com.example.demo.model.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    private final GradeMapper gradeMapper;

    @Autowired
    public GradeService(GradeMapper gradeMapper) {
        this.gradeMapper = gradeMapper;
    }

    public List<Grade> getAllGrades() {
        return gradeMapper.findAll();
    }

    public Grade getGradeById(Integer gradeId) {
        return gradeMapper.findById(gradeId);
    }

    public int createGrade(Grade grade) {
        return gradeMapper.insert(grade);
    }

    public int updateGrade(Grade grade) {
        return gradeMapper.update(grade);
    }

    public int deleteGrade(Integer gradeId) {
        return gradeMapper.delete(gradeId);
    }
}
