package ie.ait.ria.riaproject.repository;

import ie.ait.ria.riaproject.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course, Integer> {
}
