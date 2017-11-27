package by.artsiom.demo.schoolservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import by.artsiom.demo.schoolservice.delegates.SchoolServiceDelegate;

@RestController
public class SchoolController {

    @Autowired
    SchoolServiceDelegate schoolServiceDelegate;

    @RequestMapping(value = "/getSchoolDetails/{schoolname}", method = RequestMethod.GET)
    public String getStudents(@PathVariable String schoolname) {
        return schoolServiceDelegate.callStudentServiceAndGetData(schoolname);
    }
}
