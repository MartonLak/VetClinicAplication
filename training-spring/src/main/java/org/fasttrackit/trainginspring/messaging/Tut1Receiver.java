package org.fasttrackit.trainginspring.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;

import java.time.Instant;
import java.util.Date;

@RabbitListener(queues = "hello")
public class Tut1Receiver
{
    @RabbitHandler
    public void receive(String in) {

    System.out.println(" [x] Received '" + in + "'"+Date.from(Instant.now()));
    }
}
