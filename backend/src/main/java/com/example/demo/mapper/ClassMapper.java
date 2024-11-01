package com.example.demo.mapper;

import com.example.demo.model.Class;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClassMapper {

    @Select("SELECT * FROM classes")
    List<Class> findAll();

    @Select("SELECT * FROM classes WHERE classId = #{classId}")
    Class findById(Integer classId);

    @Insert("INSERT INTO classes (classId, className) VALUES (#{classId}, #{className})")
    @Options(useGeneratedKeys = true, keyProperty = "classId")
    int insert(Class clazz);

    @Update("UPDATE classes SET className = #{className} WHERE classId = #{classId}")
    int update(Class clazz);

    @Delete("DELETE FROM classes WHERE classId = #{classId}")
    int delete(Integer classId);
}
