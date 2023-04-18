package com.raquelmichelon.studentsservice;

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
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    void getStudent_forSavedStudent_isReturned() throws Exception {
        //given
        given(studentService.getStudentById(anyLong())).willReturn(
                Student.builder()
                        .id(1L)
                        .name("Mark")
                        .grade(10)
                        .build()
        );

        //when then
        mockMvc.perform(get("/students/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1L))
                .andExpect(jsonPath("name").value("Mark"))
                .andExpect(jsonPath("grade").value(10));
    }

    //testing custom exception returning right status code
    @Test
    void getStudent_forMissingStudent_status404() throws Exception {

        //given
        given(studentService.getStudentById(anyLong())).willThrow(StudentNotFoundException.class);

        //when //then
        mockMvc.perform(get("/students/1"))
                .andExpect(status().isNotFound());

    }

}


