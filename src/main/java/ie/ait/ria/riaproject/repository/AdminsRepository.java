package ie.ait.ria.riaproject.repository;

import ie.ait.ria.riaproject.entity.Admins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminsRepository extends PagingAndSortingRepository <Admins, Integer>{

}
