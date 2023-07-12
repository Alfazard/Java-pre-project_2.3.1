package com.alfazard.web_users_view.controller;

import com.alfazard.web_users_view.model.User;
import com.alfazard.web_users_view.service.ServiceUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Alfazard on 08.07.2023
 */
@Controller
public class WebController {
    private final ServiceUser userService;

    public WebController(ServiceUser userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    private String showAllUsers(Model model) {
        var allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "users";
    }

    @GetMapping("/addNewUser")
    public String newUser(Model model) {
        model.addAttribute("newUser", new User());
        return "user-info";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("newUser") User user) {
        userService.addUser(user);
        return "redirect:/";
    }
    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "edit";
    }
    @PatchMapping("edit")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
