package ie.ait.ria.riaproject.repository;

import ie.ait.ria.riaproject.entity.Students;
import ie.ait.ria.riaproject.entity.Admins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentsRepository extends PagingAndSortingRepository<Students, Integer> {
}
