package com.raquelmichelon.studentsservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @autor raqueldarellimichelon
 * created on 18/04/23 inside the package - com.raquelmichelon.studentsservice
 **/
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student getStudentByName(String name);

    @Query("select avg (grade) from Student where active=true")
    Double getAvgGradeForActiveStudents();
}
