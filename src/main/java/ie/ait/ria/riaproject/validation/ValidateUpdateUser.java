package ie.ait.ria.riaproject.validation;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class ValidateUpdateUser {

    @NotNull
    @Size(min=5,max=15, message="username should be between 5 to 15")
    private String username;

    @NotNull
    @Size(min=2,max=17, message="Name should be between 2 to 17")
    private String name;


    @NotNull
    @Email(message="Email should be valid")
    private String email;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
