// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: simple_rpc.proto

package io.grpc.generated;

public final class SimpleServiceProto {
  private SimpleServiceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_simpleservice_InputMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_simpleservice_InputMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_simpleservice_OutputMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_simpleservice_OutputMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_simpleservice_InputMessageRange_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_simpleservice_InputMessageRange_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020simple_rpc.proto\022\rsimpleservice\"\"\n\014Inp" +
      "utMessage\022\022\n\nin_message\030\001 \001(\t\"$\n\rOutputM" +
      "essage\022\023\n\013out_message\030\001 \001(\t\"=\n\021InputMess" +
      "ageRange\022\024\n\014messageStart\030\001 \001(\005\022\022\n\nmessag" +
      "eEnd\030\002 \001(\0052\254\001\n\rSimpleService\022F\n\007getData\022" +
      "\033.simpleservice.InputMessage\032\034.simpleser" +
      "vice.OutputMessage\"\000\022S\n\rgetDataStream\022 ." +
      "simpleservice.InputMessageRange\032\034.simple" +
      "service.OutputMessage\"\0000\001B,\n\016io.grpc.sim" +
      "pleB\022SimpleServiceProtoP\001\242\002\003RTGb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_simpleservice_InputMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_simpleservice_InputMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_simpleservice_InputMessage_descriptor,
        new java.lang.String[] { "InMessage", });
    internal_static_simpleservice_OutputMessage_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_simpleservice_OutputMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_simpleservice_OutputMessage_descriptor,
        new java.lang.String[] { "OutMessage", });
    internal_static_simpleservice_InputMessageRange_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_simpleservice_InputMessageRange_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_simpleservice_InputMessageRange_descriptor,
        new java.lang.String[] { "MessageStart", "MessageEnd", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
