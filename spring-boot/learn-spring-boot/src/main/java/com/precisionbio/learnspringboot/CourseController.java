package com.precisionbio.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    // url: /course
    // Course: id, name, author
    @RequestMapping("/course")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(
                new Course(1, "Learn AWS", "smyoo"),
                new Course(2, "Learn Spring Boot", "smyoo"),
                new Course(2, "Hello, Spring Boot", "smyoo"));
    }
}
