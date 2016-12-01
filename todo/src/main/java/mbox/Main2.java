package mbox;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        Client client = new Client("localhost", 13009);
        try {
            client.getEmployees();
        } finally {
            client.shutdown();
        }

    }
}

class Client {
    private final ManagedChannel channel;
    private final MailGrpc.MailBlockingStub blockingStub;

    public Client(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext(true).build();
        blockingStub = MailGrpc.newBlockingStub(channel);
    }
    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void getEmployees() {
        Mbox.Result response;
        long begin = System.currentTimeMillis();
        try {
            response = blockingStub.send(Mbox.Message.newBuilder()
                    .setFrom("from1")
                    .addTo("to1")
                    .addTo("to2")
                    .setSubject("subject1")
                    .setText("body1")
                    .build());
        } catch (StatusRuntimeException e) {
            System.out.println("RPC failed");
            return;
        }
        System.out.println("Employees: " + response);
    }

}