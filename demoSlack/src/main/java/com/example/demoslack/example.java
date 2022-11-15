package com.example.demoslack;
import com.slack.api.Slack;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.response.api.ApiTestResponse;
import com.slack.api.webhook.Payload;
import com.slack.api.webhook.WebhookResponse;

import java.io.IOException;

public class example {

    private static String CHANNEL= "temp-slack-bot";
    private static String slackWebhookUrl ="https://hooks.slack.com/services/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";
    public static void main(String[] args) throws Exception {
       /* Slack slack = Slack.getInstance();
        ApiTestResponse response = slack.methods().apiTest(r -> r.foo("bar"));
        System.out.println(response);*/

        StringBuilder str= new StringBuilder();
        str.append("ignore:: message is for testing purpose");

        Payload payload = Payload.builder().channel(CHANNEL).text(str.toString()).build();
        WebhookResponse webhookResponse= Slack.getInstance().send(slackWebhookUrl,payload);
        System.out.println(webhookResponse);
        

    }

}
