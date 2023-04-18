package com.raquelmichelon.studentclient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @autor raqueldarellimichelon
 * created on 18/04/23 inside the package - com.raquelmichelon.studentclient
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Long id;
    private String name;
    private int grade;
}


