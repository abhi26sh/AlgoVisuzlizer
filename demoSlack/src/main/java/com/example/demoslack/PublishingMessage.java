/*
package com.example.demoslack;

import com.slack.api.Slack;
import com.slack.api.methods.SlackApiException;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class PublishingMessage {

    static void publishMessage(String id, String text) {
        // you can get this instance via ctx.client() in a Bolt app
        var client = Slack.getInstance().methods();
        var logger = LoggerFactory.getLogger("my-awesome-slack-app");
        try {
            var result = client.chatPostMessage(r -> r
                            // The token you used to initialize your app
                            .token("xoxe.xoxp-1-Mi0yLTQzMjI4ODYzODkxOC00MDY2ODE1MDQ1Nzk4LTQyOTExMTkyMzI2MTQtNDMyMTQxODYyMzcxMi1mMmZmMTY2YmNlZmEzZjY1YThiZDI1NjExOGYxNzU2MjIyZWQxOTY5YWFlNDcxNWRhMTAxMDJhZDdlM2Q1NzZh")
                            .channel(id)
                            .text(text)
                            .asUser(true)
                    // You could also use a blocks[] array to send richer content
            );
            // Print result, which includes information about the message (like TS)
            logger.info("result {}", result);
        } catch (IOException | SlackApiException e) {
            logger.error("error: {}", e.getMessage(), e);
        }
    }

    public static void main(String[] args) throws Exception {
        publishMessage("C03LN7BD0K0", " ignore:: message is for testing purpose CES-94:");
    }

}*/
