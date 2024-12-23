package org.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import service.MultiplicationService;

import java.io.IOException;

public class MultiplicationServer {
    public static void main(String[] args) throws IOException,
            InterruptedException {
        Server server = ServerBuilder.forPort(9095)
                .addService(new MultiplicationService())
                .build();
        System.out.println("Serveur gRPC démarré sur le port 9095...");
        server.start();
        server.awaitTermination();
    }
}