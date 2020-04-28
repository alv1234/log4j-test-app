package com.abc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.message.StringMapMessage;

import java.util.UUID;


public class HelloWorldApp {

    private static final Logger logger = LogManager.getLogger(HelloWorldApp.class);

    public static void main(String[] args){
        ThreadContext.put("trace.id", UUID.randomUUID().toString()); //correlation id
        ThreadContext.put("transaction.id", UUID.randomUUID().toString()); //operation id

        logger.warn("a simple warn message");

        SayHello sayHello = new SayHello();
        sayHello.speak();

        //stack trace logging
        try {
            int[] myNumbers = {1, 2, 3};
            System.out.println(myNumbers[10]); // error!
        } catch(Exception e){
            logger.error("this is an error", e);
        }

        //logging Message that consists of Map works only with EcsLayout
        logger.info(new StringMapMessage()
                .with("message", "Logging a custom object")
                .with("foo", "bar"));

    }
}
