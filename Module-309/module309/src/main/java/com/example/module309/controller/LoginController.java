package com.example.module309.controller;


import com.example.module309.database.dao.UserDAO;
import com.example.module309.database.entity.User;
import com.example.module309.form.SignupFormBean;
import com.example.module309.security.AuthenticatedUserService;
import jakarta.validation.Valid;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDAO userDao;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;


    // this get mpapping is called by spring security when a secure resource is requested
    // needs to match the spring securtiy configuration  .loginPage method
    @GetMapping("/login/login")
    public ModelAndView theLoginPage() {
        ModelAndView response = new ModelAndView();

        response.setViewName("login/loginPage");

        return response;
    }


    @GetMapping("/login/signup")
    public ModelAndView signup() {
        ModelAndView response = new ModelAndView();

        response.setViewName("login/signup");

        return response;
    }

    // WE ARE DOING THIS AS A POST NOT A GET
    @PostMapping("/login/signupSubmit")
    public ModelAndView signupSubmit(@Valid SignupFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView();

        // could manually check the email from the database and ADD an error to the binding

        if ( bindingResult.hasErrors() ) {
            response.setViewName("login/signup");
            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);

        } else {
            User user = new User();

            user.setEmail(form.getUsername());
            user.setFullName(form.getFullname());

            // first we need to ecrypt the incoming password before saving it to the database
            // the password in the form is in plain text but we want to save to the database encrypted
            String encryptedPassword = passwordEncoder.encode(form.getPassword());
            user.setPassword(encryptedPassword);

            userDao.save(user);

            // redirect
            response.setViewName("redirect:/");
        }

        return response;
    }



}
