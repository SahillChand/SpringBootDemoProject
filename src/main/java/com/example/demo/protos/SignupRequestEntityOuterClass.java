// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: entity/signup_request_entity.proto
// Protobuf Java Version: 4.29.3

package com.example.demo.protos;

public final class SignupRequestEntityOuterClass {
  private SignupRequestEntityOuterClass() {}
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 29,
      /* patch= */ 3,
      /* suffix= */ "",
      SignupRequestEntityOuterClass.class.getName());
  }
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_demo_protos_SignupRequestEntity_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_example_demo_protos_SignupRequestEntity_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\"entity/signup_request_entity.proto\022\027co" +
      "m.example.demo.protos\"\177\n\023SignupRequestEn" +
      "tity\022\025\n\010username\030\001 \001(\tH\000\210\001\001\022\025\n\010password\030" +
      "\002 \001(\tH\001\210\001\001\022\024\n\007balance\030\003 \001(\001H\002\210\001\001B\013\n\t_use" +
      "rnameB\013\n\t_passwordB\n\n\010_balanceB\033\n\027com.ex" +
      "ample.demo.protosP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_example_demo_protos_SignupRequestEntity_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_example_demo_protos_SignupRequestEntity_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_com_example_demo_protos_SignupRequestEntity_descriptor,
        new java.lang.String[] { "Username", "Password", "Balance", });
    descriptor.resolveAllFeaturesImmutable();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
