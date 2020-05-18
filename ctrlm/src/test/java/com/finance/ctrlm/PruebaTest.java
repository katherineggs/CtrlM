//package com.finance.ctrlm;
//
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.context.WebApplicationContext;
//import org.thymeleaf.model.IModel;
//import static org.junit.jupiter.api.Assertions.*;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(CtrlmApplication.class)
//@AutoConfigureMockMvc
//class PruebaTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    void addCategory() {
////        Model model;
//        this.mockMvc.perform(GetMapping("/getcategories")).andExpect(status().isOk()).andExpect(model().a)
//
//        Prueba.addCategory("food,coffee", );
//        String[] names = Prueba.namesList;
//        String[] test = {"food", "coffee"};
//        for(int i = 0; i < test.length; i++) {
//            assertTrue(test[i].equals(names[i]));
//        }
//    }
//
//    @Test
//    void calculateExpenses() {
//    }
//
//    @Test
//    void calculateBalance() {
//    }
//
//    @Test
//    void incomes() {
//    }
//
//    @Test
//    void saving() {
//    }
//
//    @Test
//    void mostExpend() {
//    }
//
//    @Test
//    void leastExpend() {
//    }
//}