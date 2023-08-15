package com.precisionbio.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.precisionbio.learnjpaandhibernate.course.Course;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository courseJdbcRepository;

    @Override
    public void run(String... args) throws Exception {
        courseJdbcRepository.insert(new Course(1, "Learn AWS", "smyoo"));
        courseJdbcRepository.insert(new Course(2, "Learn Azure", "smyoo"));
        courseJdbcRepository.insert(new Course(3, "Learn DevOps", "smyoo"));
        courseJdbcRepository.deleteById(1);

        System.out.println(courseJdbcRepository.findById(2));
        System.out.println(courseJdbcRepository.findById(3));
    }

}
