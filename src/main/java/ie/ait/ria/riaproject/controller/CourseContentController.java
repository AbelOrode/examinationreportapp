package ie.ait.ria.riaproject.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:3000")
@RestController
public class CourseContentController {

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/admin", method = RequestMethod.GET)
    public String adminPing(){
        return "Admin view alone";
    }

    @PreAuthorize("hasRole('STUDENT')")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String userPing(){
        return "Student view alone";
    }

}