package com.example.module309.controller;

import com.example.module309.database.dao.CustomerDAO;
import com.example.module309.database.entity.Customer;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

    // esentially spring boot has created the dao for us when it stated up and is already in memory all we have to do is
    // autowire it and we can .. this is analagous to createing a new DAO in module 305
    @Autowired
    private CustomerDAO customerDao;

    // the nsame of thsi function does not matter .. I usally make it something
    // that means sonething to me as a human
    @GetMapping(value = { "/index", "/index123" })
    public ModelAndView index(@RequestParam(required = false) String search) {
        // I always create this the same way as the first line of the function
        ModelAndView response = new ModelAndView();

        // the goal of this controller method is to do 2 things
        // 1) establish a view name if there is to be an HTML page that goes with this
        // #6 on the archtecture image converts "index" into "/WEB-INF/jsp/index.jsp"
        response.setViewName("index");

        // 2) load any information from the database that I need to display on the page
        // this could be dozens of queries if necessary
        List<Customer> firstNames = customerDao.findByFirstName(search);
        for ( Customer c : firstNames ) {
            System.out.println(c.toString());
        }

        // once I have gathered soemthing that I want to show on the page then I add it to the model
        // the model is nothing more than a HashMap
        response.addObject("names", firstNames);

        // when I am finished and I return from this function I give control back to the
        // DispatcherServlet to continue processing the request
        // this is #5 in the architecture image
        return response;
    }


    @GetMapping("/courses/{courseId}/external_tools/{toolId}")
    public ModelAndView pathVariable(@PathVariable String courseId, @PathVariable String toolId) {
        ModelAndView response = new ModelAndView();

        System.out.println(courseId + " .... " + toolId);

        response.setViewName("xyz789");

        return response;
    }


    @GetMapping("/requestParam")
    public ModelAndView requestParam(@RequestParam String seriesId, @RequestParam String season) {
        ModelAndView response = new ModelAndView();

        System.out.println(season + " .... " + seriesId);

        response.setViewName("xyz789");

        return response;
    }


    @ResponseBody
    @GetMapping( "/indexJSON")
    public List<Customer>  indexJSON() {
        // this is out of scope and just for extra knowledge
        // if we were working with react for a front end we might do something closer to this
        // because Spring will automatically covert to JSON
        // in React we might actually create a specific DTO (Data Transport Object)
        // the DTO is essentially a custom built model for this function that return data as JSON
        List<Customer> firstNames = customerDao.findByFirstName("Alexander");
        return firstNames;
    }


    @GetMapping("/abc123")
    public ModelAndView abc123() {
        ModelAndView response = new ModelAndView();

        System.out.println("abc123");

        response.setViewName("xyz789");

        return response;
    }

}
