package com.spdb.daas.demo.service.impl;
import org.springframework.stereotype.Service;
import com.spdb.daas.demo.service.StudentService;
import com.spdb.daas.demo.dao.GradeDao;
import com.spdb.daas.demo.entity.Grade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
@Slf4j
@Service
public class StudentServiceImpl implements StudentService
{
    @Autowired
    GradeDao gradeMapper;

    @Override
    public void queryStudentGrade(int studentGrade)
    {
        List <Grade> grades=gradeMapper.queryByStudentGrade(studentGrade);
        grades.forEach(
            g->{log.info("student: {} with id {} has a grade of {}",g.getStudentID(),g.getId(),g.getGrade());}
        );
    }

    @Override
    public String  queryStudentID(int studentID)
    {
        Grade grade=gradeMapper.queryGradeByStudentID(studentID);
        if(grade!=null)
            log.info("result {}",grade.getGrade());
        else
            log.error("query returned with nothing matched!");
        return "ok";
    }

    @Override
    public String simpleTest()
    {
        return "good";
    }
}