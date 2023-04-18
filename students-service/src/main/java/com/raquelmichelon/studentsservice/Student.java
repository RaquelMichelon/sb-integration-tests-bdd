package com.raquelmichelon.studentsservice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

/**
 * @autor raqueldarellimichelon
 * created on 18/04/23 inside the package - com.raquelmichelon.studentsservice
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private boolean active;
    private int grade;

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}


