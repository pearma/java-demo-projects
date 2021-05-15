package com.spdb.daas.demo.service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;


@SpringBootTest
//@Import(com.spdb.daas.demo.dao.GradeDao.class)
public class StudentServiceTest
{

    @Autowired
    StudentService ss;

    @DisplayName("Testing Spring @Autowired Integration")
    @Test
    void testQueryByStudentID()
    {

        assertNotNull(ss);
        assertEquals("ok",ss.queryStudentID(10));
    }

}