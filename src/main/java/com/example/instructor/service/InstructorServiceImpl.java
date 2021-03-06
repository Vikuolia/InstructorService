package com.example.instructor.service;

import com.example.instructor.model.Instructor;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public List<Instructor> getAll() {
        return (List<Instructor>) instructorRepository.findAll();
    }

    @Override
    public Instructor getById(String id){
        return instructorRepository.getOne(id);
    }

    @Override
    public void deleteById(String id) {
        instructorRepository.deleteById(id);
    }
}

