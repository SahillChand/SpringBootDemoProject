package com.example.demo.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

@Configuration
public class ProtobufMessageConverterConfig {

    @Bean(name="protobufMessageConverter")
    public ProtobufHttpMessageConverter protobufHttpMessageConverter(ProtoMessageConverterConfig protoConfig) {
        return protoConfig.getHttpConverter(true);
    }
}
