package com.example.grpcclient.client;

import com.example.proto.CoinInfo;
import com.example.proto.CoinSymbol;
import com.example.proto.CoinSymbols;
import com.example.proto.CryptoCoinsServiceGrpc;
import com.example.proto.CryptoCoinsServiceGrpc.CryptoCoinsServiceBlockingStub;
import io.grpc.Deadline;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GrpcClient {

  protected ManagedChannel managedChannel;

  protected CryptoCoinsServiceBlockingStub blockingStub;

  @Value("${grpc.server.hostname}")
  private String grpcServerHostName;


  @PostConstruct
  public void init() {
    log.info("Connecting to grpc server host: "+grpcServerHostName);
    managedChannel = ManagedChannelBuilder.forTarget(grpcServerHostName)
        .usePlaintext()
        .keepAliveTime(1, TimeUnit.MINUTES)
        .build();

    blockingStub = CryptoCoinsServiceGrpc.newBlockingStub(managedChannel);

  }

  public CoinInfo getCoinDetails(String symbol) {

      CoinSymbol coinSymbol = CoinSymbol.newBuilder().setSymbol(symbol).build();
      return blockingStub.getCoinPrice(coinSymbol);

  }


  public Iterator<CoinInfo> getMultipleCoinDetails(List<String> symbols) {
    try {
      CryptoCoinsServiceBlockingStub blockingStubWithDeadline = CryptoCoinsServiceGrpc
          .newBlockingStub(managedChannel);
      CoinSymbols coinSymbols = CoinSymbols.newBuilder().addAllNames(symbols).build();

      return blockingStubWithDeadline.withDeadline(Deadline.after(300, TimeUnit.MILLISECONDS))
          .getMultipleCoinsPrice(coinSymbols);

    } catch(StatusRuntimeException e) {
      if(e.getStatus() == Status.DEADLINE_EXCEEDED) {
        log.info("Deadline has been exceeded. We dont want the response");
      } else {
        e.printStackTrace();
      }
      return null;
    }

  }

  @PreDestroy
  public void shutdown() throws InterruptedException {

    log.info("Shutting down the client...");
    shutdown(Duration.ofSeconds(60));

  }

  public void shutdown(Duration durationToWaitForChannelShutdown)
      throws InterruptedException {

    if (managedChannel == null) {
      return;
    }

    try {

      managedChannel.shutdown();
      managedChannel.awaitTermination(durationToWaitForChannelShutdown.getSeconds(), TimeUnit.SECONDS);

    } finally {

      managedChannel.shutdownNow();

      logShutdownMessage();

    }

  }

  protected void logShutdownMessage() {
    log.info("GrpcClientService has been shutdown.");
  }
}
