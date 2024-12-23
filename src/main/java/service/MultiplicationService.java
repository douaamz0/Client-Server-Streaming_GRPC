package service;

import io.grpc.stub.StreamObserver;
import stub.MultiplicationGrpc;
import stub.SalutationOuterClass;

public class MultiplicationService extends MultiplicationGrpc.MultiplicationImplBase{
    @Override
    public void getMultiplicationTable(SalutationOuterClass.MultiplicationRequest request,

                                       StreamObserver<SalutationOuterClass.MultiplicationResponse> responseObserver) {

        int nombre = request.getNombre();
        int limite = request.getLimite();
        for (int i = 1; i <= limite; i++) {
            String result = nombre + " x " + i + " = " + (nombre * i);
            SalutationOuterClass.MultiplicationResponse response = SalutationOuterClass.MultiplicationResponse.newBuilder()
                    .setResultat(result)
                    .build();
// Envoyer le message au client
            responseObserver.onNext(response);
        }
// Terminer le streaming
        responseObserver.onCompleted();
    }
}