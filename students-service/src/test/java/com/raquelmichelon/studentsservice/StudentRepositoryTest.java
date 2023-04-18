package com.raquelmichelon.studentsservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;

/**
 * @autor raqueldarellimichelon
 * created on 18/04/23 inside the package - com.raquelmichelon.studentsservice
 **/
//@SpringBootTest if will test the entire application
@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    //#1 Integration Testing Against a Real Database
    @Test
    void testGetStudentByName_returnStudentDetails() {

        //given
        Student savedStudent = testEntityManager.persistFlushFind(new Student(null, "Raquel"));

        //when
        Student student = studentRepository.getStudentByName("Raquel");

        //then
        then(student.getId()).isNotNull();
        then(student.getName()).isEqualTo(savedStudent.getName());

    }

    //#2 Integration Testing Against a Real Database using custom JPQL queries
    @Test
    void getAvgGradeForActiveStudents_calculatesAvg() {

        //given
        Student mark = Student.builder().name("Mark").active(true).grade(80).build();
        Student susan = Student.builder().name("Susan").active(true).grade(100).build();
        Student peter = Student.builder().name("Peter").active(false).grade(50).build();

        Arrays.asList(mark, susan, peter).forEach(testEntityManager::persistFlushFind);

        //when
        Double avgGrade = studentRepository.getAvgGradeForActiveStudents();

        //then
        then(avgGrade).isEqualTo(90);

    }

}


