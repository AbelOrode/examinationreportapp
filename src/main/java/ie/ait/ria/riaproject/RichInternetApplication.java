package ie.ait.ria.riaproject;

import ie.ait.ria.riaproject.entity.User;
import ie.ait.ria.riaproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class RichInternetApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;



	public static void main(String[] args) {
		SpringApplication.run(RichInternetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

for (int i=1;i<21;i++) {

	User user1 = new User();
	user1.setName("Stu"+i);
	user1.setUsername("Student"+i);
	user1.setEmail("student"+i+"@ait.ie");
	user1.setPassword("password");


	//userService.createStudent(user1);
}




	}

	@Bean
	public Docket docket(){
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.any()).build().apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
				.title("Examination Report App")
				.version("1.0")
				.description("This application allows different users to perform particular function.The users are grouped into Admin, Lecturer and Student")
				.license("Apache License Version 2.0")
				.build();
	}

}