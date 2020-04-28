package com.abc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SayHello {
    static final Logger logger = LogManager.getLogger(SayHello.class);

    public String speak() {
        logger.warn("this is a warn");
        return "Hello World";
    }
}