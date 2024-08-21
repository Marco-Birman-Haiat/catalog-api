package com.marcohaiat.catalog_api.services;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SQSService {

    @Autowired
    private AmazonSQS sqsClient;

    @Value("${aws.queueName}")
    private String queueUrl;

    public void sendMessage(String msg) {
        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl(queueUrl)
                .withMessageBody(msg)
                .withDelaySeconds(5);
        sqsClient.sendMessage(send_msg_request);
    }
}