package com.example.instructor.model;

import com.example.instructor.InstructorRequest;
import com.example.instructor.InstructorResponse;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;


@NoArgsConstructor
@EnableAutoConfiguration
@Entity
@Data
@Table(name = "instructor")
public final class Instructor{

    @Id
    private String instructorId;

    private String name;
    private String surname;
    private int background;

    public Instructor(String id, String name, String surname, int background){
        this.instructorId = id;
        this.name = name;
        this.surname = surname;
        this.background = background;
    }

}

