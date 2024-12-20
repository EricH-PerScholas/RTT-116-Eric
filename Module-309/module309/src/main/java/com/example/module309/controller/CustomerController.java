package com.example.module309.controller;

import com.example.module309.database.dao.CustomerDAO;
import com.example.module309.database.dao.EmployeeDAO;
import com.example.module309.database.entity.Customer;
import com.example.module309.database.entity.Employee;
import com.example.module309.database.entity.User;
import com.example.module309.form.CreateCustomerFormBean;
import com.example.module309.security.AuthenticatedUserService;
import jakarta.validation.Valid;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


// serverity of the error message increases going down
// as developers 90% of the time we are going to use DEBUG
// TRACE   -- this is very low level and not often used by us .. more for creators of libraries
// DEBUG   -- this is what we use most of the time when we wnat to print out stuff that helps us build
// INFO    -- this is for information that is important like the messages that spring prints when it starts up
// WARN    -- this is a potential problem or something of note but it is not an error
// ERROR   -- this is for errors like making an api call that failed OR if an exception is thrown


// slf4j is not an implementation of logging it is a specification
// most if not all other logging libraries have come to use this specification for their implementation
// log4j was the most commonly used logging library for a long time and you will probably encounter it
//@Slf4j  <-  this is from lombok and all it does is line 40
@Controller
// by putting the @PreAuthorize on the top of the controller it secures all methods in the controller
// this annotation can also be used at the method level in a controller
@PreAuthorize("hasAnyAuthority('CUSTOMER')")
public class CustomerController {

    // this is the old style logging before lombok and there is a very good chance you will see this in code somewhere
    // lombok is preferred
    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);


    @Autowired
    private CustomerDAO customerDao;

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;


    @GetMapping("/customer/search")
    public ModelAndView search(@RequestParam(required = false) String firstName) {
        ModelAndView response = new ModelAndView();

        // /WEB-INF/jsp/customer/search.jsp
        response.setViewName("customer/search");

        // add the search field to the model so we can use it on the jsp page
        response.addObject("search", firstName);

        if (firstName != null) {
            List<Customer> customers = customerDao.findByFirstName(firstName);
            response.addObject("customersKey", customers);
        }

        return response;
    }


    @GetMapping("/customer/create")
    public ModelAndView createCustomer() {
        // this just shows us the create page for the first time when the user goes to the page

        // this is the page primer for create
        ModelAndView response = new ModelAndView();

        List<Employee> employees = employeeDAO.findAllEmployees();
        response.addObject("employeesKey", employees);

        LOG.debug("DEBUG LEVEL");
        LOG.info("INFO LEVEL");
        LOG.warn("WARNING LEVEL");
        LOG.error("ERROR LEVEL");

        response.setViewName("customer/create");

        // this will get the entity from the database
        User loggedInUser = authenticatedUserService.loadCurrentUser();
        LOG.debug("!!!!!!!!!!!!!!!!!!!!!!!!!! " + loggedInUser.toString());

        return response;
    }

    @GetMapping("/customer/edit/{customerId}")
    public ModelAndView editCustomer(@PathVariable Integer customerId) {
        ModelAndView response = new ModelAndView();
        // this is the page primer for edit
        response.setViewName("customer/create");

        LOG.debug("============= EDITING CUSTOMER " + customerId);

        Customer customer = customerDao.findById(customerId);

        CreateCustomerFormBean form = new CreateCustomerFormBean();

        form.setId(customer.getId());
        form.setCompanyName(customer.getCustomerName());
        form.setFirstName(customer.getContactFirstname());
        form.setLastName(customer.getContactLastname());
        form.setAddressLine1(customer.getAddressLine1());
        form.setPhone(customer.getPhone());
        form.setCity(customer.getCity());
        form.setCountry(customer.getCountry());
        form.setEmployeeId(customer.getSalesRepEmployeeId());
        // alternate form.setEmployeeId(customer.getEmployee().getId());

        response.addObject("form", form);

        List<Employee> employees = employeeDAO.findAllEmployees();
        response.addObject("employeesKey", employees);

        return response;
    }

    @GetMapping("/customer/createCustomer")
    public ModelAndView createCustomerSubmit(@Valid CreateCustomerFormBean form, BindingResult bindingResult) {
        // this is called when the user clicks the submit button on the form
        ModelAndView response = new ModelAndView();

        // manually do some validations here in the controller

        LOG.debug(form.toString());

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                LOG.debug(error.toString());
            }
            response.setViewName("customer/create");
            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);

            List<Employee> employees = employeeDAO.findAllEmployees();
            response.addObject("employeesKey", employees);
        } else {
            // when this is a create the id in the form will be null
            // when it is an edit the id in the form will be populated with the PK to edit
            // in either case we can try to query the database and its either found or not
            // if its not found in the database its a create
            // if it is found in the database then its an edit
            Customer customer = customerDao.findById(form.getId());
            if ( customer == null ) {
                customer = new Customer();
            }

            customer.setCustomerName(form.getCompanyName());
            customer.setContactFirstname(form.getFirstName());
            customer.setContactLastname(form.getLastName());
            customer.setPhone(form.getPhone());
            customer.setAddressLine1(form.getAddressLine1());
            customer.setCity(form.getCity());
            customer.setCountry(form.getCountry());

            Employee employee = employeeDAO.findById(form.getEmployeeId());
            customer.setEmployee(employee);

            customerDao.save(customer);

            LOG.debug("============= SAVING CUSTOMER " + customer.getId());

            // in either case ... create or edit .. I now want to redirect to the edit url
            response.setViewName("redirect:/customer/edit/" + customer.getId() );

        }

        return response;
    }

}
