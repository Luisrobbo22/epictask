package br.com.fiap.epictask.controller;

import br.com.fiap.epictask.model.User;
import br.com.fiap.epictask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/user/new")
    public String create(User user) {
        return "user-form";
    }

    @GetMapping(value = "/user")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("users");
        List<User> users = userRepository.findAll();
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @PostMapping(value = "/user")
    public String save(@Valid User user, BindingResult result) {
        if (result.hasErrors())
            return "user-form";
        userRepository.save(user);
        System.out.println("Salvando usuário..." + user);
        return "redirect:user";
    }
}