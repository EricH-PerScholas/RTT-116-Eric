package com.example.module309.controller;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSearch() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/customer/search")
                        .with(user("a@b.com").authorities(new SimpleGrantedAuthority("CUSTOMER"))))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(view().name("customer/search"));
    }

    @Test
    public void testSearchResult() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/customer/search")
                        .param("firstName", "eeee")
                        .with(user("a@b.com").authorities(new SimpleGrantedAuthority("CUSTOMER"))))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attributeExists("customersKey"))
                .andExpect(model().attribute("search", "eeee"))
                .andExpect(view().name("customer/search"));
    }
}
