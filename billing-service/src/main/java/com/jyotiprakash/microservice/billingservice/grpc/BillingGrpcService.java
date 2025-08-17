package com.jyotiprakash.microservice.billingservice.grpc;

import billing.BillingResponse;
import net.devh.boot.grpc.server.service.GrpcService;
import billing.BillingServiceGrpc;     // <-- generated package
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class BillingGrpcService extends BillingServiceGrpc.BillingServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(
            BillingGrpcService.class);


    @Override
    public void createBillingAccount(billing.BillingRequest request,
                                     io.grpc.stub.StreamObserver<billing.BillingResponse> responseObserver) {

        log.info("createBillingAccount request received {}", request.toString());

        BillingResponse billingResponse = BillingResponse.newBuilder()
                .setAccountId("12345")
                .setStatus("ACTIVE")
                .build();
        responseObserver.onNext(billingResponse);
        responseObserver.onCompleted();

    }
}
