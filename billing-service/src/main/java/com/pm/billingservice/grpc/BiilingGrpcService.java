package com.pm.billingservice.grpc;

import billing.BillingServiceGrpc;
import com.pm.billingservice.BillingServiceApplication;
import net.devh.boot.grpc.server.service.GrpcService;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@GrpcService
public class BiilingGrpcService extends BillingServiceGrpc.BillingServiceImplBase
{
    public static final Logger log= LoggerFactory.getLogger(BiilingGrpcService.class);

 @Override
    public void createBillingAccount(billing.BillingRequest billingRequest,
                                     StreamObserver<billing.BillingResponse> responseObserver){

     log.info("Create Billing Account request received {}",billingRequest.toString()) ;

     //Business logic - e.g save to database , perform calculation etc only for testing
     billing.BillingResponse billingResponse= billing.BillingResponse.newBuilder()
             .setAccountId("12345")
             .setStatus("ACTIVE")
             .build();
     responseObserver.onNext(billingResponse);
     responseObserver.onCompleted();
 }

}
