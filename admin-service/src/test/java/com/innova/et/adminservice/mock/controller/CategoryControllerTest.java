//package com.innova.et.adminservice.mock.controller;
//
//
//import com.innova.et.adminservice.AdminServiceApplication;
//import com.innova.et.adminservice.controller.CategoryController;
//import com.innova.et.adminservice.service.CategoryService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
//import org.springframework.boot.test.autoconfigure.OverrideAutoConfiguration;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//
//@WebMvcTest(controllers = CategoryController.class)
////@OverrideAutoConfiguration(
////        enabled = true
////)
////@ImportAutoConfiguration
////@ActiveProfiles({"test"})
//public class CategoryControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private CategoryService categoryService;
//
//    @Test
//    void getAll() throws Exception {
//        mockMvc.perform(
//                get("/category")
//                .accept(MediaType.APPLICATION_JSON)
//        ).andExpect(status().isOk());
//    }
//}
