package com.spdb.daas.demo.dao;
import com.spdb.daas.demo.entity.Grade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface GradeDao{
   public  Grade queryGradeByStudentID(@Param("id") int id);

   public List<Grade> queryByStudentGrade(@Param("grade") int grade);
}