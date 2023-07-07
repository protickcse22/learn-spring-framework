package com.protick.speingboot.learnjpaandhibernate.course;

import com.protick.speingboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.protick.speingboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.protick.speingboot.learnjpaandhibernate.course.springjpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    /*@Autowired
    private CourseJpaRepository repository;*/

    /*@Autowired
    private CourseJdbcRepository repository;*/

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running...");
       /* repository.insert(new Course(1, "Java jap", "Protick"));
        repository.insert(new Course(2, "python jap", "Protick"));
        repository.insert(new Course(3, "C# jap", "Protick"));
        repository.delete(1);
        System.out.println(repository.findCourseByID(3));*/
        repository.save(new Course(1, "Java  spring jap", "Protick"));
        repository.save(new Course(2, "python spring jap", "Protick"));
        repository.save(new Course(3, "C# spring jap", "Protick"));
        repository.deleteById(2L);
        System.out.println(repository.findById(3L));
        System.out.println(repository.findAll());
        System.out.println(repository.count());
        System.out.println(repository.findByAuthor("Protick"));
        System.out.println(repository.findByAuthor(""));
        System.out.println(repository.findByName("Java  spring jap"));
        System.out.println(repository.findByName(""));

    }
}
