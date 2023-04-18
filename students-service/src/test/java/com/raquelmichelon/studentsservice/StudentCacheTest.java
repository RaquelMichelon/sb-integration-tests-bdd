package com.raquelmichelon.studentsservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

/**
 * @autor raqueldarellimichelon
 * created on 18/04/23 inside the package - com.raquelmichelon.studentsservice
 **/
@SpringBootTest(webEnvironment = NONE)
public class StudentCacheTest {

    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;


    //integration test for cache
    @Test
    void getStudentById_forMultipleRequests_isRetrieveFromCache() {

        //given
        Long id = 123L;
        given(studentRepository.findById(id)).willReturn(Optional.of(new Student(null, "Mark")));

        //when
        studentService.getStudentById(id);
        studentService.getStudentById(id);
        studentService.getStudentById(id);


        //then
        then(studentRepository).should(times(1)).findById(id);
    }
}


