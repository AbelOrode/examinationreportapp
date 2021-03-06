package ie.ait.ria.riaproject.repository;

import ie.ait.ria.riaproject.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.List;


@Repository
//@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends JpaRepository <User, Integer>{

    User findByUsername(String s);
    User findById(int id);

    User findByEmail(String s);

    @Query(nativeQuery = true,value="Select user_id as id, user.name,user.email,user.username from cma.user inner join user_roles on user_roles.user_id=user.id inner join role on role.id=user_roles.role_id where role.name='STUDENT' and user.username= ?;")
    Object searchStudent(String username);

    @Query(nativeQuery = true,value="Select user_id as id, user.name,user.email,user.username from cma.user inner join user_roles on user_roles.user_id=user.id inner join role on role.id=user_roles.role_id where role.name='LECTURER' and user.username= ?;")
    Object searchLecturer(String username);

    @Query(nativeQuery = true,value="Select user_id as id, user.name,user.email,user.username from cma.user inner join user_roles on user_roles.user_id=user.id inner join role on role.id=user_roles.role_id where role.name='ADMIN' and user.username= ?;")
   Object searchAdmin(String username);

    @Query(nativeQuery = true,value="Select grade.module_name,grade.grade_percentage from user inner join grade on user.id=grade.user_id where user.username= ?;")
    List<Object> studentGrades(String username);


}
