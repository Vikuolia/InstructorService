package com.example.instructor.service;

import com.example.instructor.model.Instructor;

import java.util.List;

public interface InstructorService {

    Instructor addInstructor(Instructor instructor);

    List<Instructor> getAll();

    Instructor getById(String id);

    void deleteById(String id);
}

