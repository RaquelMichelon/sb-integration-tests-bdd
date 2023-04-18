package com.raquelmichelon.studentclient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.okJson;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static org.assertj.core.api.BDDAssertions.then;

/**
 * @autor raqueldarellimichelon
 * created on 18/04/23 inside the package - com.raquelmichelon.studentclient
 *
 * Ensuring client app (rest call) and web app (controller) are in sync using groovy contract
 *
 **/
@SpringBootTest
//@AutoConfigureWireMock //runs on port 8080 by default
@AutoConfigureStubRunner(ids = "com.raquelmichelon.studentsservice:+:8080", stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class StudentClientTest {

    @Autowired
    private StudentClient studentClient;

    @Test
    void getStudent_forGivenStudent_isReturned() {
        //given
        Long id = 1L;
//        stubFor(get("/students/" + id).willReturn(okJson("""
//                {
//                "id": 1,
//                "studentName": "Mark",
//                "grade": 10
//                }
//                """)));

        //when
        Student student = studentClient.getStudent(id);

        //then
        then(student.getId()).isNotNull();
        then(student.getName()).isEqualTo("Mark");
        then(student.getGrade()).isEqualTo(10);
    }
}


