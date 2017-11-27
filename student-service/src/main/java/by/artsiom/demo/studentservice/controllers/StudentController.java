package by.artsiom.demo.studentservice.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import by.artsiom.demo.studentservice.entities.Student;

@RestController
public class StudentController {

    private static Map<String, List<Student>> schools = new HashMap<String, List<Student>>();

    static {
        schools = new HashMap<String, List<Student>>();

        schools.put("37", Arrays.asList(
                new Student("Artem", "Class 8"),
                new Student("Andrew", "Class 1"),
                new Student("Ryhor", "Class 9"),
                new Student("Kat", "Class 7"),
                new Student("Dima", "Class 7"),
                new Student("Sergey", "Class 8"),
                new Student("Maxim", "Class 3")
                ));
        schools.put("14", Arrays.asList(
                new Student("Ivan", "Class 4"),
                new Student("Dasha", "Class 4"),
                new Student("Sergey", "Class 1"),
                new Student("Liza", "Class 5"),
                new Student("Nastya", "Class 1"),
                new Student("Andrey", "Class 6"),
                new Student("Nina", "Class 2")
                ));
        schools.put("8", Arrays.asList(
                new Student("Ivan", "Class 6"),
                new Student("Zhenya", "Class 6"),
                new Student("Inna", "Class 3"),
                new Student("Vasil", "Class 4"),
                new Student("Pavel", "Class 6"),
                new Student("Denis", "Class 4"),
                new Student("Naum", "Class 1")
                ));

    }

    @RequestMapping(value = "/getStudents/{school}", method = RequestMethod.GET)
    public List<Student> getStudents(@PathVariable String school) {
        System.out.println("Getting Student details for " + school);

        List<Student> studentList = schools.get(school);
        if (studentList == null) {
            studentList = new ArrayList<Student>();
            Student std = new Student("Not Found", "N/A");
            studentList.add(std);
        }
        return studentList;
    }
}
