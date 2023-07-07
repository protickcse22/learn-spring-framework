package com.protick.speingboot.learnjpaandhibernate.course.springjpa;

import com.protick.speingboot.learnjpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

    List<Course> findByName(String name);
    List<Course> findByAuthor(String author);

}
