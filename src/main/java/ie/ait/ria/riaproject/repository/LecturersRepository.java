package ie.ait.ria.riaproject.repository;

import ie.ait.ria.riaproject.entity.Lecturers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface LecturersRepository extends PagingAndSortingRepository<Lecturers, Integer>{
}
