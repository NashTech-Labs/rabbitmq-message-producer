package com.knoldus.rabbitMQ.producer;


import com.knoldus.rabbitMQ.config.FeedMessagingConfig;
import com.knoldus.rabbitMQ.model.FeedData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping("/rabbitmq")
public class FeedDataProducer {

    @Autowired
    private RabbitTemplate template;

    @GetMapping(path = "/created")
    public String feeds() {
        // SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        Timestamp time = new Timestamp(System.currentTimeMillis());
        FeedData feedData = new FeedData(15, 6, "gaurav@gmail.com", "knolx", "apache kafka", "apache kafka demo", time
                , "knolx/publish", null, null);

        template.convertAndSend(FeedMessagingConfig.FEED_EXCHANGE, FeedMessagingConfig.FEED_ROUTING_KEY, feedData);
        return "data send Successfully into database !!";
    }
}
