package com.example.demo.Configuration;

import com.google.protobuf.util.JsonFormat;
import lombok.Getter;
import org.springframework.http.converter.protobuf.ProtobufJsonFormatHttpMessageConverter;
import org.springframework.stereotype.Component;

@Getter
@Component("protoMessageConverter")
public class ProtoMessageConverterConfig {

    private final JsonFormat.TypeRegistry typeRegistry;
    private final JsonFormat.Parser parser;
    private final JsonFormat.Printer printer;

    public ProtoMessageConverterConfig() {
        this.typeRegistry = JsonFormat.TypeRegistry.newBuilder().build(); // Empty registry
        this.parser = JsonFormat.parser().usingTypeRegistry(typeRegistry).ignoringUnknownFields();
        this.printer = JsonFormat.printer().usingTypeRegistry(typeRegistry)
                .preservingProtoFieldNames()
                .includingDefaultValueFields()
                .omittingInsignificantWhitespace();
    }

    public ProtoMessageConverterConfig(JsonFormat.TypeRegistry typeRegistry) {
        this.typeRegistry = typeRegistry;
        this.parser = JsonFormat.parser().usingTypeRegistry(typeRegistry).ignoringUnknownFields();
        this.printer = JsonFormat.printer().usingTypeRegistry(typeRegistry)
                .preservingProtoFieldNames()
                .includingDefaultValueFields()
                .omittingInsignificantWhitespace();
    }

    public ProtobufJsonFormatHttpMessageConverter getHttpConverter(boolean usingProtoFieldNames) {
        JsonFormat.Printer httpConverterPrinter = JsonFormat.printer()
                .usingTypeRegistry(this.typeRegistry)
                .includingDefaultValueFields()
                .omittingInsignificantWhitespace();

        if (usingProtoFieldNames) {
            httpConverterPrinter = httpConverterPrinter.preservingProtoFieldNames();
        }

        return new ProtobufJsonFormatHttpMessageConverter(this.parser, httpConverterPrinter);
    }
}

