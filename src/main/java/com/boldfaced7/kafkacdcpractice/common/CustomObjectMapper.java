package com.boldfaced7.kafkacdcpractice.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class CustomObjectMapper extends ObjectMapper {

    public CustomObjectMapper() {
        registerModule(new JavaTimeModule());
    }
}
