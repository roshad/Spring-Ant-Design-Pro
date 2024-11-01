package com.example.demo.service;

import com.example.demo.mapper.ClassMapper;
import com.example.demo.model.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    private final ClassMapper classMapper;

    @Autowired
    public ClassService(ClassMapper classMapper) {
        this.classMapper = classMapper;
    }

    public List<Class> getAllClasses() {
        return classMapper.findAll();
    }

    public Class getClassById(Integer classId) {
        return classMapper.findById(classId);
    }

    public int createClass(Class clazz) {
        return classMapper.insert(clazz);
    }

    public int updateClass(Class clazz) {
        return classMapper.update(clazz);
    }

    public int deleteClass(Integer classId) {
        return classMapper.delete(classId);
    }
}
