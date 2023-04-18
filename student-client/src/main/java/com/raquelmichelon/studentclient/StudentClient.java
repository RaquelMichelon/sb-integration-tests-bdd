package com.raquelmichelon.studentclient;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @autor raqueldarellimichelon
 * created on 18/04/23 inside the package - com.raquelmichelon.studentclient
 **/
@Component
@RequiredArgsConstructor
public class StudentClient {

    @Autowired
    private final WebClient webClient;


    public Student getStudent(Long id) {
        return webClient
                .get()
                .uri("/student/{id}", id)
                .retrieve()
                .bodyToMono(Student.class)
                .block();
    }
}


