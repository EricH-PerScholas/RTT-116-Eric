package com.example.module309.controller;

import com.example.module309.database.dao.CustomerDAO;
import com.example.module309.database.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

    // esentially spring boot has created the dao for us when it stated up and is already in memory all we have to do is
    // autowire it and we can .. this is analagous to createing a new DAO in module 305
    @Autowired
    private CustomerDAO customerDao;

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView response = new ModelAndView();

        // this is our index.jsp
        response.setViewName("index");

        List<Customer> firstNames = customerDao.findByFirstName("Alexander");
        for ( Customer c : firstNames ) {
            System.out.println(c.toString());
        }

        response.addObject("names", firstNames);

        return response;
    }

}
