package ie.ait.ria.riaproject.service.impl;

import ie.ait.ria.riaproject.entity.*;
import ie.ait.ria.riaproject.entity.Module;
import ie.ait.ria.riaproject.exception.ExceptionHandler;
import ie.ait.ria.riaproject.repository.*;
import ie.ait.ria.riaproject.service.UserService;
import ie.ait.ria.riaproject.validation.ShowGrade;
import ie.ait.ria.riaproject.validation.ValidateUpdateUser;
import ie.ait.ria.riaproject.validation.ValidateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service(value = "userService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LecturersRepository lecturersRepository;

    @Autowired
    private AdminsRepository adminsRepository;

    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private GradeRepository gradeRepository;


    @Override
    public User createStudent(User user) {

        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));;
        newUser.setEmail(user.getEmail());
        newUser.setName(user.getName());

        // add default role of 'USER'
        Role role = new Role();
        role.setName("STUDENT");
        role.setDescription("This is a student role");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        newUser.setRoles(roleSet);

        Module mod= new Module();
        mod.setModuleName("Rich Internet Application");

        Module mod1= new Module();
        mod1.setModuleName("Database System");

        Module mod2= new Module();
        mod2.setModuleName("Data Visualization");

        Module mod3= new Module();
        mod3.setModuleName("Cyber Security");

        Module mod4= new Module();
        mod4.setModuleName("Agile Methodology");

        Module mod5= new Module();
        mod5.setModuleName("Software Design");

        Set<Module> ms= new HashSet<>();
        ms.add(mod);ms.add(mod1);ms.add(mod2);ms.add(mod3);ms.add(mod4);ms.add(mod5);

        newUser.setModules(ms);

        return userRepository.save(newUser);
    }

    @Override

    public User createLecturer(User user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));;
        newUser.setEmail(user.getEmail());
        newUser.setName(user.getName());


        // add default role of 'USER'
        Role role = new Role();
        role.setName("LECTURER");
        role.setDescription("This is a lecturer role");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        newUser.setRoles(roleSet);

        Module mod= new Module();
        mod.setModuleName("Agile Methodology");

        Module mod1= new Module();
        mod1.setModuleName("Software Design");



        Set<Module> ms= new HashSet<>();
        ms.add(mod);ms.add(mod1);

        newUser.setModules(ms);


        return userRepository.save(newUser);
    }

    @Override
    public User createAdmin(User user) {

        if(userRepository.findByUsername(user.getUsername())!=null){
            throw new ExceptionHandler("Admin with this username already exist");

        }

        else if(userRepository.findByEmail(user.getEmail())!=null){
            throw new ExceptionHandler("Admin with this email already exist");
        }
        else {

            User newUser = new User();
            newUser.setUsername(user.getUsername());
            newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
            ;
            newUser.setEmail(user.getEmail());
            newUser.setName(user.getName());


            // add default role of 'USER'
            Role role = new Role();
            role.setName("ADMIN");
            role.setDescription("This is an admin role");
            Set<Role> roleSet = new HashSet<>();
            roleSet.add(role);
            newUser.setRoles(roleSet);

            return userRepository.save(newUser);
        }

    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> getAllLecturers(int pageNumber, int pageSize, String sortBy, String sortDir) {
        return  (Page)lecturersRepository.findAll(
                PageRequest.of(pageNumber,pageSize,sortDir.equalsIgnoreCase("asc")? Sort.by(sortBy).ascending(): Sort.by(sortBy).descending())
        );
    }



    @Override
    public Page<User> getAllStudents(int pageNumber, int pageSize, String sortBy, String sortDir) {
        return  (Page)studentsRepository.findAll(
                PageRequest.of(pageNumber,pageSize,sortDir.equalsIgnoreCase("asc")? Sort.by(sortBy).ascending(): Sort.by(sortBy).descending())
        );
    }


    @Override
    public Page<User> getAllAdmins(Pageable pageable) {
        return  (Page)adminsRepository.findAll(pageable);
    }

    @Override
    public Object searchAdmin(String username) {
        Object admin= userRepository.searchAdmin(username);
        if(admin==null){
            throw new ExceptionHandler("This admin doesn't exist, make sure you");
        }
        else{
            return userRepository.searchAdmin(username);
        }

    }

    @Override
    public Object searchLecturer(String username) {
        Object lecturer= userRepository.searchLecturer(username);
        if(lecturer==null){
            throw new ExceptionHandler("This lecturer doesn't exist, make sure you entered the correct username type");
        }
        else{
            return userRepository.searchLecturer(username);
        }
    }

    @Override
    public Object searchStudent(String username) {
        Object student= userRepository.searchStudent(username);

        if(student==null){
            throw new ExceptionHandler("This student doesn't exist, make sure you entered the correct username type");
        }
        else{
            return userRepository.searchStudent(username);
        }
    }

    @Override
    public Object updateUser(ValidateUpdateUser user) {
        User user1= userRepository.findByUsername(user.getUsername());

        if(user1==null){
            throw new ExceptionHandler("Username doesnt exist");
        }
        else{

            user1.setEmail(user.getEmail());
            user1.setName(user.getName());
            return userRepository.save(user1);

        }
    }



    @Override
    public List<Module> findModule(String name) {
        List<Module> module=moduleRepository.findByModuleName(name);
        if(module==null){
            throw new ExceptionHandler("Module with this id doesnt exist");
        }
        else{
            return module;
        }

    }

    @Override
    public List<String> findUserModules(String username) {
        User u= userRepository.findByUsername(username);

        if(u==null){
            return null;
        }
        else{
            List<String> list= new ArrayList<>();
            for(Module m:u.getModules()){
                list.add(m.getModuleName());
            }
            return list;
        }

    }

    @Override
    public List<Object> findAllStudentsModule(String username) {

        return moduleRepository.findStudentToModule(username);
    }

    @Override
    public Grade postOrUploadGrades(String username, String moduleName,int gradePercentage) {
        User user = userRepository.findByUsername(username);

        Grade grade = gradeRepository.findByUserAndModuleName(user, moduleName);


        if (grade == null) {
            Grade grade1 = new Grade();

            grade1.setGradePercentage(gradePercentage);
            grade1.setUser(user);
            grade1.setModuleName(moduleName);

            return gradeRepository.save(grade1);
        } else {
            grade.setGradePercentage(gradePercentage);
            return gradeRepository.save(grade);

        }
    }

    @Override
    public List<Object> studentGrades(String username) {
        User user= userRepository.findByUsername(username);

        List<Object> newGradeList= userRepository.studentGrades(user.getUsername());

        return newGradeList;
    }

    @Override
    public ShowGrade findStudentGradeForAModule(String username, String module) {
        User user= userRepository.findByUsername(username);
        Grade grade= gradeRepository.findByUserAndModuleName(user,module);

        ShowGrade sg= new ShowGrade();

        sg.setUsername(user.getUsername());
        sg.setGradePercentage(grade.getGradePercentage());

        return sg;

    }

    @Override
    public Boolean deleteUser(String username) {

        User user1= userRepository.findByUsername(username);

        if(user1==null){

            throw new ExceptionHandler("Username doesnt exist, make sure there is a user with that username");
        }
        else{
            userRepository.delete(user1);
            return true;
        }

    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {

            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;

    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(s);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));

    }

}