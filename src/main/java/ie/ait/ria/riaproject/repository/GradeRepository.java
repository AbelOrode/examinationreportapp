package ie.ait.ria.riaproject.repository;

import ie.ait.ria.riaproject.entity.Grade;
import ie.ait.ria.riaproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface GradeRepository extends JpaRepository<Grade, Integer> {

    Grade findByUserAndModuleName(User user, String name);

    List<Grade> findByUser(User user);

}
