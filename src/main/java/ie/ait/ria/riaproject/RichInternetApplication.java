package ie.ait.ria.riaproject;

import ie.ait.ria.riaproject.entity.User;
import ie.ait.ria.riaproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RichInternetApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;



	public static void main(String[] args) {
		SpringApplication.run(RichInternetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


			User user1 = new User();
			user1.setName("MR.ABEL");
			user1.setUsername("James");
			user1.setPassword("password");
			user1.setEmail("james@gmail.com");



			//userService.createLecturer(user1);




	}}