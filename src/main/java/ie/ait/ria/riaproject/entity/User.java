package ie.ait.ria.riaproject.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "user")
public class User {
   @Id
   @GeneratedValue(strategy = IDENTITY)
   private int id;

   @NotNull
   @Column(nullable = false)
   private String username;

   @NotNull
   @Column(nullable = false)
   private String password;

   @NotNull
   @Column(nullable = false)
   private String name;

   private String email;

   @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   @JoinTable(
           name = "user_roles",
           joinColumns = {@JoinColumn(name = "user_id")},
           inverseJoinColumns = {@JoinColumn(name = "role_id")})
           Set <Role> roles;

   @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   @JoinTable(
           name = "user_modules",
           joinColumns = {@JoinColumn(name = "user_id")},
           inverseJoinColumns = {@JoinColumn(name = "module_id")})
   Set<Module> modules;

   public int getId(){return id;}

   public void setId(int id){this.id = id;}

   public String getUsername(){return username;}

   public void setUsername(String username){this.username = username;}

   public String getPassword(){return password;}

   public void setPassword(String password){this.password = password;}

   public String getName(){return name;}

   public void setName(String name){this.name = name;}

   public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }

   public Set<Role> getRoles() {
      return roles;
   }
   public void setRoles(Set<Role> roles) {
      this.roles = roles;
   }
   public Set<Module> getModules() {
      return modules;
   }
   public void setModules(Set<Module> modules) {
      this.modules = modules;
   }


}
