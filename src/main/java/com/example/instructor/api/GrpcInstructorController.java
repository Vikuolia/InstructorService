package com.example.instructor.api;

import com.example.instructor.*;
import com.example.instructor.model.Instructor;
import com.example.instructor.service.InstructorService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@GrpcService
public class GrpcInstructorController extends InstructorServiceGrpc.InstructorServiceImplBase{

    @Autowired
    private InstructorService instructorService;

    @Override
    public void add(InstructorRequest request, StreamObserver<InstructorResponse> responseObserver){
        String name = request.getName();
        String surname = request.getSurname();
        int background = request.getBackground();

        Instructor instructorAdd = new Instructor(name, surname, background);
        Instructor instructorResponse = instructorService.addInstructor(instructorAdd);

        InstructorResponse response = InstructorResponse.newBuilder()
                                                        .setId(instructorResponse.getInstructorId())
                                                        .setName(instructorResponse.getName())
                                                        .setSurname(instructorResponse.getSurname())
                                                        .setBackground(instructorResponse.getBackground())
                                                        .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void all(AllInstructorsRequest request, StreamObserver<AllInstructorsResponse> responseObserver) {
        List<Instructor> instructors = instructorService.getAll();
        List<InstructorResponse> instructorResponses= new ArrayList<>();

        for(Instructor instructor: instructors){
            InstructorResponse oneResponse = InstructorResponse.newBuilder()
                                                               .setId(instructor.getInstructorId())
                                                               .setName(instructor.getName())
                                                               .setSurname(instructor.getSurname())
                                                               .setBackground(instructor.getBackground())
                                                               .build();
            instructorResponses.add(oneResponse);
        }
        AllInstructorsResponse response = AllInstructorsResponse.newBuilder().addAllInstructors(instructorResponses)
                                                                             .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void byId(InstructorByIdRequest request, StreamObserver<InstructorResponse> responseObserver){
        Instructor instructor = instructorService.getById(request.getId());

        InstructorResponse response = InstructorResponse.newBuilder()
                                                        .setId(instructor.getInstructorId())
                                                        .setName(instructor.getName())
                                                        .setSurname(instructor.getSurname())
                                                        .setBackground(instructor.getBackground())
                                                        .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void delete(InstructorByIdRequest request, StreamObserver<DeleteInstructorResponse> responseObserver) {
        instructorService.deleteById(request.getId());
        DeleteInstructorResponse response = DeleteInstructorResponse.newBuilder()
                .setResponse("Instructor with id " + request.getId() + " was deleted")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
