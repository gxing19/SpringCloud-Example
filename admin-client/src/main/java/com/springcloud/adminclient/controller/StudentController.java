package com.springcloud.adminclient.controller;

import com.springcloud.adminclient.entity.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @name: StudentController
 * @desc: TODO
 * @author: gxing
 * @date: 2019-06-05 16:07
 **/
@RestController
@RequestMapping("/stu")
public class StudentController {

    @RequestMapping("/getStudent")
    public Student getStudent(){
        return new Student(12,new Date());
    }
}