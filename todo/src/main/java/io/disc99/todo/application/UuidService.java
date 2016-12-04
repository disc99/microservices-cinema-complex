package io.disc99.todo.application;

import io.disc99.uuid.Uuid;
import io.disc99.uuid.UuidGeneratorGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class UuidService {
    
    ManagedChannel channel;
    UuidGeneratorGrpc.UuidGeneratorBlockingStub stub;

    public UuidService(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build();
        stub = UuidGeneratorGrpc.newBlockingStub(channel);
    }

    public String generate(String key) {
        return stub.generate(Uuid.UuidRequest.newBuilder()
                .setKey(key)
                .build()).getUuid();
    }

}
