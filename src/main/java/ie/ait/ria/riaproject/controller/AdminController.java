package ie.ait.ria.riaproject.controller;


import ie.ait.ria.riaproject.validation.ValidateUpdateUser;
import ie.ait.ria.riaproject.exception.ExceptionHandler;
import ie.ait.ria.riaproject.config.TokenProvider;
import ie.ait.ria.riaproject.entity.User;
import ie.ait.ria.riaproject.service.UserService;
import ie.ait.ria.riaproject.validation.ValidateUsername;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import java.util.Collection;
import java.util.List;


@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserService userService;


    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/allLecturers", method = RequestMethod.GET)
    public Page<User> listLecturers(int pageNumber, int pageSize, String sortBy, String sortDir){
        return userService.getAllLecturers(pageNumber, pageSize, sortBy, sortDir);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/allStudents", method = RequestMethod.GET)
    public Page<User> listStudents(int pageNumber, int pageSize, String sortBy, String sortDir){
        return userService.getAllStudents(pageNumber, pageSize, sortBy, sortDir);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/allAdmins", method = RequestMethod.GET)
    public Page<User> listAdmins(Pageable pageable){
        return userService.getAllAdmins(pageable);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/searchLecturer", method = RequestMethod.GET)
    public Object searchLecturer( @RequestParam("username")String username){

        try{
            Object user= userService.searchLecturer(username);
            return ResponseEntity
                    .ok(user);
        }
        catch (ExceptionHandler e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/searchStudent", method = RequestMethod.GET)
    public Object searchStudent( @RequestParam("username")String username){
        //System.out.println(username+" this is my username");
        try{
            Object user= userService.searchStudent(username);
            return ResponseEntity
                    .ok(user);
        }
        catch (ExceptionHandler e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/updateUser")
    public ResponseEntity<?>  updateUser(@Valid @RequestBody ValidateUpdateUser validateUpdateUser, BindingResult bindingresult) throws ExceptionHandler {



        if (bindingresult.hasErrors()) {
            //System.out.println("Invalid fields number"+bindingresult.getErrorCount() +"The first error"+bindingresult.getFieldError().getField());
            return ResponseEntity.badRequest().body("Error Count:" + bindingresult.getErrorCount() + ", an error has occurred on field " + bindingresult.getFieldError().getField());
        } else {
            try {
                userService.updateUser(validateUpdateUser);
                return ResponseEntity
                        .ok("success");
            } catch (ExceptionHandler e) {

                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteUser")
    public ResponseEntity<?>  deleteUser(@RequestParam String username) throws ExceptionHandler {

        System.out.println(username);

        if (username.trim() == "" || username.length() < 5 || username.length() > 15) {
            return ResponseEntity.badRequest().body("Max length exceeded");
        } else {
            try {
                userService.deleteUser(username);
                return ResponseEntity
                        .ok("successfully deleted");
            } catch (ExceptionHandler e) {

                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }
    }


}