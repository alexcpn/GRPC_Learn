package io.grpc.generated;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.0.3)",
    comments = "Source: simple_rpc.proto")
public class SimpleServiceGrpc {

  private SimpleServiceGrpc() {}

  public static final String SERVICE_NAME = "simpleservice.SimpleService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.grpc.generated.InputMessage,
      io.grpc.generated.OutputMessage> METHOD_GET_DATA =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "simpleservice.SimpleService", "getData"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.generated.InputMessage.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.generated.OutputMessage.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.grpc.generated.InputMessageRange,
      io.grpc.generated.OutputMessage> METHOD_GET_DATA_STREAM =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
          generateFullMethodName(
              "simpleservice.SimpleService", "getDataStream"),
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.generated.InputMessageRange.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(io.grpc.generated.OutputMessage.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SimpleServiceStub newStub(io.grpc.Channel channel) {
    return new SimpleServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SimpleServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SimpleServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static SimpleServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SimpleServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class SimpleServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * A simple RPC.
     * Obtains the feature at a given position.
     * A feature with an empty name is returned if there's no feature at the given
     * position.
     * </pre>
     */
    public void getData(io.grpc.generated.InputMessage request,
        io.grpc.stub.StreamObserver<io.grpc.generated.OutputMessage> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_DATA, responseObserver);
    }

    /**
     * <pre>
     * A server-to-client streaming RPC.
     * </pre>
     */
    public void getDataStream(io.grpc.generated.InputMessageRange request,
        io.grpc.stub.StreamObserver<io.grpc.generated.OutputMessage> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_DATA_STREAM, responseObserver);
    }

    @java.lang.Override public io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_DATA,
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.generated.InputMessage,
                io.grpc.generated.OutputMessage>(
                  this, METHODID_GET_DATA)))
          .addMethod(
            METHOD_GET_DATA_STREAM,
            asyncServerStreamingCall(
              new MethodHandlers<
                io.grpc.generated.InputMessageRange,
                io.grpc.generated.OutputMessage>(
                  this, METHODID_GET_DATA_STREAM)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SimpleServiceStub extends io.grpc.stub.AbstractStub<SimpleServiceStub> {
    private SimpleServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SimpleServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SimpleServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SimpleServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * A simple RPC.
     * Obtains the feature at a given position.
     * A feature with an empty name is returned if there's no feature at the given
     * position.
     * </pre>
     */
    public void getData(io.grpc.generated.InputMessage request,
        io.grpc.stub.StreamObserver<io.grpc.generated.OutputMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_DATA, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * A server-to-client streaming RPC.
     * </pre>
     */
    public void getDataStream(io.grpc.generated.InputMessageRange request,
        io.grpc.stub.StreamObserver<io.grpc.generated.OutputMessage> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_GET_DATA_STREAM, getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SimpleServiceBlockingStub extends io.grpc.stub.AbstractStub<SimpleServiceBlockingStub> {
    private SimpleServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SimpleServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SimpleServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SimpleServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * A simple RPC.
     * Obtains the feature at a given position.
     * A feature with an empty name is returned if there's no feature at the given
     * position.
     * </pre>
     */
    public io.grpc.generated.OutputMessage getData(io.grpc.generated.InputMessage request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_DATA, getCallOptions(), request);
    }

    /**
     * <pre>
     * A server-to-client streaming RPC.
     * </pre>
     */
    public java.util.Iterator<io.grpc.generated.OutputMessage> getDataStream(
        io.grpc.generated.InputMessageRange request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_GET_DATA_STREAM, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SimpleServiceFutureStub extends io.grpc.stub.AbstractStub<SimpleServiceFutureStub> {
    private SimpleServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SimpleServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SimpleServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SimpleServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * A simple RPC.
     * Obtains the feature at a given position.
     * A feature with an empty name is returned if there's no feature at the given
     * position.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.generated.OutputMessage> getData(
        io.grpc.generated.InputMessage request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_DATA, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_DATA = 0;
  private static final int METHODID_GET_DATA_STREAM = 1;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SimpleServiceImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(SimpleServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_DATA:
          serviceImpl.getData((io.grpc.generated.InputMessage) request,
              (io.grpc.stub.StreamObserver<io.grpc.generated.OutputMessage>) responseObserver);
          break;
        case METHODID_GET_DATA_STREAM:
          serviceImpl.getDataStream((io.grpc.generated.InputMessageRange) request,
              (io.grpc.stub.StreamObserver<io.grpc.generated.OutputMessage>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    return new io.grpc.ServiceDescriptor(SERVICE_NAME,
        METHOD_GET_DATA,
        METHOD_GET_DATA_STREAM);
  }

}
