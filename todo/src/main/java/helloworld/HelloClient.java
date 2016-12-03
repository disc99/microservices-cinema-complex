package helloworld;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class HelloClient {
    ManagedChannel channel;
    GreeterGrpc.GreeterBlockingStub blockingStub;
    GreeterGrpc.GreeterFutureStub futureStub;
    GreeterGrpc.GreeterStub stub;

    HelloClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build();
        blockingStub = GreeterGrpc.newBlockingStub(channel);
        futureStub = GreeterGrpc.newFutureStub(channel);
        stub = GreeterGrpc.newStub(channel);
    }

    void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    void getEmployees() {
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

    void g1() {
        Iterator<Helloworld.HelloReply> replyIterator = blockingStub.listSayHello(null);
    }

    void g2() {
        StreamObserver<Helloworld.HelloRequest> sayHellos = stub.sayHellos(null);
    }

    static void main(String[] args) throws Exception {
        HelloClient client = new HelloClient("localhost", 50051);
        try {
            client.getEmployees();
        } finally {
            client.shutdown();
        }
    }}
