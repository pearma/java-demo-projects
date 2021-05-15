package com.spdb.daas.demo.controller;
import com.spdb.daas.demo.service.MultiThreadService;
import com.spdb.daas.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/query")

public class QueryController
{
    @Autowired
    StudentService ss;

    @Autowired
    MultiThreadService mt;

    @GetMapping(value="/studentid")
    public String queryStudentGradeByID(@RequestParam("userid") int id)
    {
        ss.queryStudentID(id);
        return String.format("query student by id %d",id);
    }

    @GetMapping(value="/grade")
    public String queryStudentGrade(@RequestParam("grade") int grade)
    {
        ss.queryStudentGrade(grade);
        return String.format("query student by grade %d", grade);
        
    }   

    @GetMapping(value="/mt")
    public String mtDemo()
    {
        for(int i=0;i<3;i++)
            mt.show();
        return "multi thread test";
        
    }       
}