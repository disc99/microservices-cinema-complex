package mbox;

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
    comments = "Source: mbox.proto")
public class MailGrpc {

  private MailGrpc() {}

  public static final String SERVICE_NAME = "mbox.Mail";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<mbox.Mbox.Message,
      mbox.Mbox.Result> METHOD_SEND =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "mbox.Mail", "Send"),
          io.grpc.protobuf.ProtoUtils.marshaller(mbox.Mbox.Message.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(mbox.Mbox.Result.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<mbox.Mbox.Folder,
      mbox.Mbox.Message> METHOD_RECEIVE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
          generateFullMethodName(
              "mbox.Mail", "Receive"),
          io.grpc.protobuf.ProtoUtils.marshaller(mbox.Mbox.Folder.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(mbox.Mbox.Message.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MailStub newStub(io.grpc.Channel channel) {
    return new MailStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MailBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MailBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static MailFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MailFutureStub(channel);
  }

  /**
   */
  public static abstract class MailImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Send mail
     * </pre>
     */
    public void send(mbox.Mbox.Message request,
        io.grpc.stub.StreamObserver<mbox.Mbox.Result> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEND, responseObserver);
    }

    /**
     * <pre>
     * Receive new mail
     * </pre>
     */
    public void receive(mbox.Mbox.Folder request,
        io.grpc.stub.StreamObserver<mbox.Mbox.Message> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_RECEIVE, responseObserver);
    }

    @Override public io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_SEND,
            asyncUnaryCall(
              new MethodHandlers<
                mbox.Mbox.Message,
                mbox.Mbox.Result>(
                  this, METHODID_SEND)))
          .addMethod(
            METHOD_RECEIVE,
            asyncServerStreamingCall(
              new MethodHandlers<
                mbox.Mbox.Folder,
                mbox.Mbox.Message>(
                  this, METHODID_RECEIVE)))
          .build();
    }
  }

  /**
   */
  public static final class MailStub extends io.grpc.stub.AbstractStub<MailStub> {
    private MailStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MailStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected MailStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MailStub(channel, callOptions);
    }

    /**
     * <pre>
     * Send mail
     * </pre>
     */
    public void send(mbox.Mbox.Message request,
        io.grpc.stub.StreamObserver<mbox.Mbox.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEND, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Receive new mail
     * </pre>
     */
    public void receive(mbox.Mbox.Folder request,
        io.grpc.stub.StreamObserver<mbox.Mbox.Message> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_RECEIVE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MailBlockingStub extends io.grpc.stub.AbstractStub<MailBlockingStub> {
    private MailBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MailBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected MailBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MailBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Send mail
     * </pre>
     */
    public mbox.Mbox.Result send(mbox.Mbox.Message request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEND, getCallOptions(), request);
    }

    /**
     * <pre>
     * Receive new mail
     * </pre>
     */
    public java.util.Iterator<mbox.Mbox.Message> receive(
        mbox.Mbox.Folder request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_RECEIVE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MailFutureStub extends io.grpc.stub.AbstractStub<MailFutureStub> {
    private MailFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MailFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected MailFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MailFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Send mail
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<mbox.Mbox.Result> send(
        mbox.Mbox.Message request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEND, getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND = 0;
  private static final int METHODID_RECEIVE = 1;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MailImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(MailImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND:
          serviceImpl.send((mbox.Mbox.Message) request,
              (io.grpc.stub.StreamObserver<mbox.Mbox.Result>) responseObserver);
          break;
        case METHODID_RECEIVE:
          serviceImpl.receive((mbox.Mbox.Folder) request,
              (io.grpc.stub.StreamObserver<mbox.Mbox.Message>) responseObserver);
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
        METHOD_SEND,
        METHOD_RECEIVE);
  }

}
