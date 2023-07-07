package com.protick.speingboot.learnjpaandhibernate.course.jpa;

import com.protick.speingboot.learnjpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course) {
        entityManager.merge(course);
        System.out.println("Insert complete");
    }

    public void delete(long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }

    public Course findCourseByID(long id) {
        System.out.println(entityManager.find(Course.class, id));
        return entityManager.find(Course.class, id);
    }

}
