package ie.ait.ria.riaproject.controller;

import ie.ait.ria.riaproject.config.TokenProvider;
import ie.ait.ria.riaproject.entity.Grade;
import ie.ait.ria.riaproject.service.UserService;
import ie.ait.ria.riaproject.entity.Module;
import ie.ait.ria.riaproject.validation.ShowGrade;
import ie.ait.ria.riaproject.validation.ValidateGrade;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/lecturer")
public class LecturerController {



    @Autowired
    private UserService userService;


    @PreAuthorize("hasAnyRole('LECTURER', 'ADMIN')")
    @RequestMapping(value="/studentModule", method = RequestMethod.GET)
    public List<Object> findStudentModule(@RequestParam("name")String modulename){
        //System.out.println(username+" this is my username");


        return userService.findAllStudentsModule(modulename);
    }

    @PreAuthorize("hasAnyRole('ADMIN','LECTURER')")
    @RequestMapping(value="/searchLecturer/modules", method = RequestMethod.GET)
    public List<String> findModule(@RequestParam("username")String username){

        return userService.findUserModules(username);

    }

    @PreAuthorize("hasAnyRole('LECTURER')")
    @RequestMapping(value="/postGrades", method = RequestMethod.POST)
    public Grade uploadGrades(@Valid @RequestBody ValidateGrade validateGrade){




        return userService.postOrUploadGrades(validateGrade.getUsername(), validateGrade.getName(), validateGrade.getGrade());
    }


    @PreAuthorize("hasAnyRole('LECTURER', 'ADMIN')")
    @RequestMapping(value="/findGrade", method = RequestMethod.GET)
    public ShowGrade getGrade(@RequestParam("username")String username, @RequestParam("module")String module){


        return userService.findStudentGradeForAModule(username,module);

    }

}