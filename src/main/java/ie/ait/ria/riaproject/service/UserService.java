package ie.ait.ria.riaproject.service;

import ie.ait.ria.riaproject.entity.Grade;
import ie.ait.ria.riaproject.entity.Module;
import ie.ait.ria.riaproject.entity.User;
import ie.ait.ria.riaproject.validation.ShowGrade;
import ie.ait.ria.riaproject.validation.ValidateUpdateUser;
import ie.ait.ria.riaproject.validation.ValidateUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    User createStudent(User user);
    User createLecturer(User user);
    User createAdmin(User user);

    List<User> findAllUsers();



    Page<User> getAllLecturers(int pageNumber,int pageSize,String sortBy,String sortDir);

    Page<User> getAllStudents(int pageNumber,int pageSize,String sortBy,String sortDir);
    Page<User> getAllAdmins(Pageable pageable);







    Object searchAdmin(String username);
    Object searchLecturer(String username);
    Object searchStudent(String username);

    Object updateUser(ValidateUpdateUser user);

    Boolean deleteUser(String username);
    List<Module> findModule(String name);

    List<String> findUserModules(String username);

    List<Object> findAllStudentsModule(String username);

    Grade postOrUploadGrades(String username, String moduleName, int grade);

    List<Object> studentGrades(String username);

    ShowGrade findStudentGradeForAModule(String username, String module);
}
