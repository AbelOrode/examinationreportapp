package ie.ait.ria.riaproject.controller;


import ie.ait.ria.riaproject.config.TokenProvider;
import ie.ait.ria.riaproject.entity.AuthToken;
import ie.ait.ria.riaproject.entity.LoginUser;
import ie.ait.ria.riaproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private UserService userService;


    @PreAuthorize("hasAnyRole('STUDENT', 'ADMIN')")
    @RequestMapping(value="/myGrades", method = RequestMethod.GET)
    public List<Object> getGrades(@RequestParam("username")String username){


        return userService.studentGrades(username);



    }
}