// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: dto/asset_trade_request_dto.proto
// Protobuf Java Version: 4.29.3

package com.example.demo.protos;

public final class AssetTradeRequestDTOOuterClass {
  private AssetTradeRequestDTOOuterClass() {}
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 29,
      /* patch= */ 3,
      /* suffix= */ "",
      AssetTradeRequestDTOOuterClass.class.getName());
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
    internal_static_com_example_demo_protos_AssetTradeRequestDTO_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_example_demo_protos_AssetTradeRequestDTO_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n!dto/asset_trade_request_dto.proto\022\027com" +
      ".example.demo.protos\"\246\001\n\024AssetTradeReque" +
      "stDTO\022\022\n\005asset\030\001 \001(\tH\000\210\001\001\022\025\n\010currency\030\002 " +
      "\001(\tH\001\210\001\001\022\030\n\013weight_unit\030\003 \001(\tH\002\210\001\001\022\025\n\010qu" +
      "antity\030\004 \001(\001H\003\210\001\001B\010\n\006_assetB\013\n\t_currency" +
      "B\016\n\014_weight_unitB\013\n\t_quantityB;\n\027com.exa" +
      "mple.demo.protosB\036AssetTradeRequestDTOOu" +
      "terClassP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_example_demo_protos_AssetTradeRequestDTO_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_example_demo_protos_AssetTradeRequestDTO_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_com_example_demo_protos_AssetTradeRequestDTO_descriptor,
        new java.lang.String[] { "Asset", "Currency", "WeightUnit", "Quantity", });
    descriptor.resolveAllFeaturesImmutable();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
