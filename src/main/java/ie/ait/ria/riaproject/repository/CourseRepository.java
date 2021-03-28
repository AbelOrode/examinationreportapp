package ie.ait.ria.riaproject.repository;

import ie.ait.ria.riaproject.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "courses", path = "courses")
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
