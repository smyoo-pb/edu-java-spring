package com.precisionbio.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.precisionbio.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.precisionbio.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.precisionbio.learnjpaandhibernate.course.jpa.CourseSpringDataJpaRepository;

@Component
public class CourseommandLineRunner implements CommandLineRunner {

    // @Autowired
    // private CourseJdbcRepository repository;

    // @Autowired
    // private CourseJpaRepository repository;
    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn AWS", "smyoo"));
        repository.save(new Course(2, "Learn Azure", "smyoo"));
        repository.save(new Course(3, "Learn DevOps", "smyoo"));
        repository.deleteById(1l);

        System.out.println(repository.findById(2l));
        System.out.println(repository.findById(3l));

        System.out.println(repository.findAll());
        System.out.println(repository.findByAuthor("smyoo"));
        System.out.println(repository.findByName("Learn DevOps"));
    }

}
