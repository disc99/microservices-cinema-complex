package helloworld;

import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;

public class HelloClient {
    private final ManagedChannel channel;
    private final GreeterGrpc.GreeterBlockingStub blockingStub;

    public HelloClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext(true).build();
        blockingStub = GreeterGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void getEmployees() {
        Helloworld.HelloReply response;
        long begin = System.currentTimeMillis();
        try {
            response = blockingStub.sayHello(Helloworld.HelloRequest.newBuilder().build());
        } catch (StatusRuntimeException e) {
            System.out.println("RPC failed");
            return;
        }
        System.out.println("Employees: " + response.getMessage());
    }

    public static void main(String[] args) throws Exception {
        HelloClient client = new HelloClient("localhost", 50051);
        try {
            client.getEmployees();
        } finally {
            client.shutdown();
        }
    }}
