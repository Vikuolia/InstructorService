package com.example.instructor.rabbitmq;

import com.example.instructor.model.Instructor;
import com.example.instructor.service.InstructorService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.instructor.rabbitmq.Config.QUEUE;

@Component
public class Consumer {

    @Autowired
    InstructorService instructorService;

    @RabbitListener(queues = QUEUE)
    public  void consumeMessageFromQueue(Instructor instructor){
        System.out.println(instructorService.addInstructor(instructor));
    }
}

