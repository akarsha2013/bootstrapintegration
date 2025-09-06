package in.akarsh.jdbcapidemo.controller;

import in.akarsh.jdbcapidemo.model.User;
import in.akarsh.jdbcapidemo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String readAll(Model model){
        List<User> users =userService.findAll();
        //for time being
     //   users.forEach(user -> System.out.println(user.getName()));
        model.addAttribute("users",users);
        return "users-list";
    }
    @GetMapping("/new")
    public String showUserForm(Model model){
        model.addAttribute("user",new User());
     return "user-form";
    }
    @PostMapping ("/users")
     public String processUsers(@ModelAttribute("user")User user){
        //only for testing purpose
       // System.out.println(user.getName()+","+user.getEmail());
        if (user.getId() != null)
        {
            //UPDATE OPERATION
            userService.updateUser(user);
        }else {
            //CREATE operation
            userService.createUser(user);
        }
      //  userService.createUser(user);
        //refresh the table
        return "redirect:/list";

     }
     @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
       // System.out.println("Printing the id::"+id);
         userService.deleteUser(id);
         return "redirect:/list";
     }
    @GetMapping("/edit/{id}")
    public String findUserById(@PathVariable("id") Long id,Model model){
        // System.out.println("Printing the id::"+id);
       User existingUser = userService.findUserById(id);
       model.addAttribute("user",existingUser);
        return "user-form";
    }
}
