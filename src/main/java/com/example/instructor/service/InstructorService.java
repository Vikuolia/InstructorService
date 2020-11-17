package com.example.instructor.service;

import com.example.instructor.model.Instructor;
import javassist.NotFoundException;

import java.util.List;

public interface InstructorService {

    Instructor addInstructor(Instructor instructor);

    List<Instructor> getAll();

    Instructor getById(String id) throws NotFoundException;

    void deleteById(String id);
}

