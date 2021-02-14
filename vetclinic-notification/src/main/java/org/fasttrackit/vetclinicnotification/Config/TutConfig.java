package org.fasttrackit.vetclinicnotification.Config;



import org.fasttrackit.vetclinicnotification.messaging.TutReceiver;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class TutConfig
{
    @Bean
    public Queue hello() {
        return new Queue("hello");
    }

    @Profile("receiver")
    @Bean
    public TutReceiver receiver() {
        return new TutReceiver();
    }
}
