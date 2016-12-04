package io.disc99.uuid;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.0.0)",
    comments = "Source: uuid.proto")
public class UuidGeneratorGrpc {

  private UuidGeneratorGrpc() {}

  public static final String SERVICE_NAME = "uuid.UuidGenerator";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Uuid.UuidRequest,
      Uuid.UuidResponse> METHOD_GENERATE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "uuid.UuidGenerator", "Generate"),
          io.grpc.protobuf.ProtoUtils.marshaller(Uuid.UuidRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(Uuid.UuidResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UuidGeneratorStub newStub(io.grpc.Channel channel) {
    return new UuidGeneratorStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UuidGeneratorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UuidGeneratorBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static UuidGeneratorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UuidGeneratorFutureStub(channel);
  }

  /**
   */
  public static abstract class UuidGeneratorImplBase implements io.grpc.BindableService {

    /**
     */
    public void generate(Uuid.UuidRequest request,
        io.grpc.stub.StreamObserver<Uuid.UuidResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GENERATE, responseObserver);
    }

    @Override public io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GENERATE,
            asyncUnaryCall(
              new MethodHandlers<
                Uuid.UuidRequest,
                Uuid.UuidResponse>(
                  this, METHODID_GENERATE)))
          .build();
    }
  }

  /**
   */
  public static final class UuidGeneratorStub extends io.grpc.stub.AbstractStub<UuidGeneratorStub> {
    private UuidGeneratorStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UuidGeneratorStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected UuidGeneratorStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UuidGeneratorStub(channel, callOptions);
    }

    /**
     */
    public void generate(Uuid.UuidRequest request,
        io.grpc.stub.StreamObserver<Uuid.UuidResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GENERATE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UuidGeneratorBlockingStub extends io.grpc.stub.AbstractStub<UuidGeneratorBlockingStub> {
    private UuidGeneratorBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UuidGeneratorBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected UuidGeneratorBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UuidGeneratorBlockingStub(channel, callOptions);
    }

    /**
     */
    public Uuid.UuidResponse generate(Uuid.UuidRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GENERATE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UuidGeneratorFutureStub extends io.grpc.stub.AbstractStub<UuidGeneratorFutureStub> {
    private UuidGeneratorFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UuidGeneratorFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected UuidGeneratorFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UuidGeneratorFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Uuid.UuidResponse> generate(
        Uuid.UuidRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GENERATE, getCallOptions()), request);
    }
  }

  private static final int METHODID_GENERATE = 0;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UuidGeneratorImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(UuidGeneratorImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GENERATE:
          serviceImpl.generate((Uuid.UuidRequest) request,
              (io.grpc.stub.StreamObserver<Uuid.UuidResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
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
        METHOD_GENERATE);
  }

}
