// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: entity/update_balance_request_entity.proto
// Protobuf Java Version: 4.29.3

package com.example.demo.protos;

/**
 * Protobuf type {@code com.example.demo.protos.UpdateBalanceRequestEntity}
 */
public final class UpdateBalanceRequestEntity extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:com.example.demo.protos.UpdateBalanceRequestEntity)
    UpdateBalanceRequestEntityOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 29,
      /* patch= */ 3,
      /* suffix= */ "",
      UpdateBalanceRequestEntity.class.getName());
  }
  // Use UpdateBalanceRequestEntity.newBuilder() to construct.
  private UpdateBalanceRequestEntity(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private UpdateBalanceRequestEntity() {
    username_ = "";
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.example.demo.protos.UpdateBalanceRequestEntityOuterClass.internal_static_com_example_demo_protos_UpdateBalanceRequestEntity_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.example.demo.protos.UpdateBalanceRequestEntityOuterClass.internal_static_com_example_demo_protos_UpdateBalanceRequestEntity_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.example.demo.protos.UpdateBalanceRequestEntity.class, com.example.demo.protos.UpdateBalanceRequestEntity.Builder.class);
  }

  private int bitField0_;
  public static final int USERNAME_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object username_ = "";
  /**
   * <code>optional string username = 1;</code>
   * @return Whether the username field is set.
   */
  @java.lang.Override
  public boolean hasUsername() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>optional string username = 1;</code>
   * @return The username.
   */
  @java.lang.Override
  public java.lang.String getUsername() {
    java.lang.Object ref = username_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      username_ = s;
      return s;
    }
  }
  /**
   * <code>optional string username = 1;</code>
   * @return The bytes for username.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getUsernameBytes() {
    java.lang.Object ref = username_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      username_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int BALANCE_FIELD_NUMBER = 2;
  private double balance_ = 0D;
  /**
   * <code>optional double balance = 2;</code>
   * @return Whether the balance field is set.
   */
  @java.lang.Override
  public boolean hasBalance() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>optional double balance = 2;</code>
   * @return The balance.
   */
  @java.lang.Override
  public double getBalance() {
    return balance_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (((bitField0_ & 0x00000001) != 0)) {
      com.google.protobuf.GeneratedMessage.writeString(output, 1, username_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeDouble(2, balance_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(1, username_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(2, balance_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.example.demo.protos.UpdateBalanceRequestEntity)) {
      return super.equals(obj);
    }
    com.example.demo.protos.UpdateBalanceRequestEntity other = (com.example.demo.protos.UpdateBalanceRequestEntity) obj;

    if (hasUsername() != other.hasUsername()) return false;
    if (hasUsername()) {
      if (!getUsername()
          .equals(other.getUsername())) return false;
    }
    if (hasBalance() != other.hasBalance()) return false;
    if (hasBalance()) {
      if (java.lang.Double.doubleToLongBits(getBalance())
          != java.lang.Double.doubleToLongBits(
              other.getBalance())) return false;
    }
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasUsername()) {
      hash = (37 * hash) + USERNAME_FIELD_NUMBER;
      hash = (53 * hash) + getUsername().hashCode();
    }
    if (hasBalance()) {
      hash = (37 * hash) + BALANCE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          java.lang.Double.doubleToLongBits(getBalance()));
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.example.demo.protos.UpdateBalanceRequestEntity parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.demo.protos.UpdateBalanceRequestEntity parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.demo.protos.UpdateBalanceRequestEntity parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.demo.protos.UpdateBalanceRequestEntity parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.demo.protos.UpdateBalanceRequestEntity parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.demo.protos.UpdateBalanceRequestEntity parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.demo.protos.UpdateBalanceRequestEntity parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static com.example.demo.protos.UpdateBalanceRequestEntity parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.example.demo.protos.UpdateBalanceRequestEntity parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.example.demo.protos.UpdateBalanceRequestEntity parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.demo.protos.UpdateBalanceRequestEntity parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static com.example.demo.protos.UpdateBalanceRequestEntity parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.example.demo.protos.UpdateBalanceRequestEntity prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.example.demo.protos.UpdateBalanceRequestEntity}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.example.demo.protos.UpdateBalanceRequestEntity)
      com.example.demo.protos.UpdateBalanceRequestEntityOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.example.demo.protos.UpdateBalanceRequestEntityOuterClass.internal_static_com_example_demo_protos_UpdateBalanceRequestEntity_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.example.demo.protos.UpdateBalanceRequestEntityOuterClass.internal_static_com_example_demo_protos_UpdateBalanceRequestEntity_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.example.demo.protos.UpdateBalanceRequestEntity.class, com.example.demo.protos.UpdateBalanceRequestEntity.Builder.class);
    }

    // Construct using com.example.demo.protos.UpdateBalanceRequestEntity.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      username_ = "";
      balance_ = 0D;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.example.demo.protos.UpdateBalanceRequestEntityOuterClass.internal_static_com_example_demo_protos_UpdateBalanceRequestEntity_descriptor;
    }

    @java.lang.Override
    public com.example.demo.protos.UpdateBalanceRequestEntity getDefaultInstanceForType() {
      return com.example.demo.protos.UpdateBalanceRequestEntity.getDefaultInstance();
    }

    @java.lang.Override
    public com.example.demo.protos.UpdateBalanceRequestEntity build() {
      com.example.demo.protos.UpdateBalanceRequestEntity result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.example.demo.protos.UpdateBalanceRequestEntity buildPartial() {
      com.example.demo.protos.UpdateBalanceRequestEntity result = new com.example.demo.protos.UpdateBalanceRequestEntity(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.example.demo.protos.UpdateBalanceRequestEntity result) {
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.username_ = username_;
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.balance_ = balance_;
        to_bitField0_ |= 0x00000002;
      }
      result.bitField0_ |= to_bitField0_;
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.example.demo.protos.UpdateBalanceRequestEntity) {
        return mergeFrom((com.example.demo.protos.UpdateBalanceRequestEntity)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.example.demo.protos.UpdateBalanceRequestEntity other) {
      if (other == com.example.demo.protos.UpdateBalanceRequestEntity.getDefaultInstance()) return this;
      if (other.hasUsername()) {
        username_ = other.username_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (other.hasBalance()) {
        setBalance(other.getBalance());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              username_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 17: {
              balance_ = input.readDouble();
              bitField0_ |= 0x00000002;
              break;
            } // case 17
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.lang.Object username_ = "";
    /**
     * <code>optional string username = 1;</code>
     * @return Whether the username field is set.
     */
    public boolean hasUsername() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>optional string username = 1;</code>
     * @return The username.
     */
    public java.lang.String getUsername() {
      java.lang.Object ref = username_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        username_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string username = 1;</code>
     * @return The bytes for username.
     */
    public com.google.protobuf.ByteString
        getUsernameBytes() {
      java.lang.Object ref = username_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        username_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string username = 1;</code>
     * @param value The username to set.
     * @return This builder for chaining.
     */
    public Builder setUsername(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      username_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>optional string username = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearUsername() {
      username_ = getDefaultInstance().getUsername();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>optional string username = 1;</code>
     * @param value The bytes for username to set.
     * @return This builder for chaining.
     */
    public Builder setUsernameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      username_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private double balance_ ;
    /**
     * <code>optional double balance = 2;</code>
     * @return Whether the balance field is set.
     */
    @java.lang.Override
    public boolean hasBalance() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>optional double balance = 2;</code>
     * @return The balance.
     */
    @java.lang.Override
    public double getBalance() {
      return balance_;
    }
    /**
     * <code>optional double balance = 2;</code>
     * @param value The balance to set.
     * @return This builder for chaining.
     */
    public Builder setBalance(double value) {

      balance_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>optional double balance = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearBalance() {
      bitField0_ = (bitField0_ & ~0x00000002);
      balance_ = 0D;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:com.example.demo.protos.UpdateBalanceRequestEntity)
  }

  // @@protoc_insertion_point(class_scope:com.example.demo.protos.UpdateBalanceRequestEntity)
  private static final com.example.demo.protos.UpdateBalanceRequestEntity DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.example.demo.protos.UpdateBalanceRequestEntity();
  }

  public static com.example.demo.protos.UpdateBalanceRequestEntity getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UpdateBalanceRequestEntity>
      PARSER = new com.google.protobuf.AbstractParser<UpdateBalanceRequestEntity>() {
    @java.lang.Override
    public UpdateBalanceRequestEntity parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<UpdateBalanceRequestEntity> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UpdateBalanceRequestEntity> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.example.demo.protos.UpdateBalanceRequestEntity getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

