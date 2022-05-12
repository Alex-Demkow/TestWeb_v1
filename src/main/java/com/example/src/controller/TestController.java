package com.example.src.controller;

import com.example.src.model.User;
import com.example.src.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class TestController {
    //@RequestParam(name = "val1", required = false, defaultValue = "4") Integer val1,
//
//                   @RequestParam(name = "val2", required = false, defaultValue = "6") Integer val2
    @Autowired
    private UserService service;

    @GetMapping()
    public String getUserList() {
        return null;
    }

    @GetMapping("/index")
    public String getIndex(Model model) {
        model.addAttribute("users", service.getAllUserList());
        return "index";
    }

    @GetMapping("/signup")
    public String addUsersPoing(User user) {
        return "add-user";
    }

    @PostMapping(value = "/adduser")
    public String adduser(@Valid User user,
                          Model model) {
        service.createUser(user);


        return "redirect:/index";
    }

    @PostMapping("/update/{name}")
    public String updateUser(@PathVariable(name = "name") String name,
                             @Valid User user,
                             BindingResult result,
                             Model model) {
        service.updateUser(user);

        return "redirect:/index";
    }

    @GetMapping("/edit/{name}")
    public String editUserPoint(@PathVariable(name = "name") String name,
                                Model model) {
        model.addAttribute("user", service.getUser(name));
        return "update-user";
    }


    @GetMapping("/delete/{name}")
    public String deleteUser(@PathVariable(name = "name") String name, Model model) {
        service.deleteUser(name);
        return "redirect:/index";
    }

//    @PostMapping("/addDog/{name}")
//    public String addDog(@PathVariable(name = "name") String name,
//                             @Valid User user,
//                             BindingResult result,
//                             Model model) {
//        service.updateUser(user);
//
//        return "redirect:/index";
//    }

@GetMapping("/addDog/{name}")
public String addDog(@PathVariable(name = "name") String name,
                            Model model) {
    model.addAttribute("user", service.getUser(name));
    return "dogName";
}

    @PostMapping("/addDog/{name}")
    public String addDog(@PathVariable(name = "name") String name,
                             @Valid User user,
                             BindingResult result,
                             Model model) {
        service.updateUser(user);

        return "redirect:/index";
    }

}
