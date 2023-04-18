package com.raquelmichelon.studentsservice;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @autor raqueldarellimichelon
 * created on 18/04/23 inside the package - com.raquelmichelon.studentsservice
 **/
@WebMvcTest
public class StudentControllerBaseClass {
    @MockBean
    private StudentService studentService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void before() {

        RestAssuredMockMvc.mockMvc(mockMvc);
        //given
        given(studentService.getStudentById(anyLong())).willReturn(
                Student.builder()
                        .id(1L)
                        .name("Mark")
                        .grade(10)
                        .build()
        );
    }
}


