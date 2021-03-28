package ie.ait.ria.riaproject.service;

import ie.ait.ria.riaproject.entity.User;
import ie.ait.ria.riaproject.validation.ValidateUpdateUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    User createStudent(User user);
    User createLecturer(User user);
    User createAdmin(User user);

    List<User> findAllUsers();


    Page<User> getAllLectures(Pageable pageable);
    Page<User> getAllStudents(Pageable pageable);
    Page<User> getAllAdmins(Pageable pageable);




    Object searchAdmin(String username);
    Object searchLecturer(String username);
    Object searchStudent(String username);

    Object updateUser(ValidateUpdateUser user);

    Boolean deleteUser(String username);
}
