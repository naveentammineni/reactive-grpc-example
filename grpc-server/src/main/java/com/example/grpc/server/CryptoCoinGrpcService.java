package com.example.grpc.server;

import com.example.proto.CoinInfo;
import com.example.proto.CoinSymbol;
import com.example.proto.CoinSymbols;
import com.example.proto.ReactorCryptoCoinsServiceGrpc;
import io.grpc.Context;
import io.grpc.Context.CancellableContext;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@GrpcService
@Slf4j
public class CryptoCoinGrpcService extends ReactorCryptoCoinsServiceGrpc.CryptoCoinsServiceImplBase {

  @Autowired
  private CoinsService coinsService;

  @Override
  public Mono<CoinInfo> getCoinPrice(Mono<CoinSymbol> coinSymbolRequest) {

    return coinSymbolRequest
        .flatMap( request -> coinsService.getCoinPrice(request.getSymbol()));
  }

  @Override
  public Flux<CoinInfo> getMultipleCoinsPrice(Mono<CoinSymbols> multipleCoinsRequest) {
//    Context current = Context.current();

    try {

      /*for(int i=0; i< 3; i++){

        if(!current.isCancelled()){
          log.info("sleeping for 100ms");
          log.info("remaining deadline: "+current.getDeadline());
          Thread.sleep(100);

        } else {
          return null;
        }
      }*/

//      CancellableContext withCancellation = Context.current().withCancellation();
//      try {
//        withCancellation.run(new Runnable() {
//          public void run() {
//            Context current = Context.current();
//            if (!current.isCancelled()) {
//              multipleCoinsRequest
//                  .flatMapMany(request -> coinsService
//                      .findCoinDetailsForMultipleSymbols(request.getNamesList(), current));
//            }
//          }
//        });
//      } catch (Throwable t) {
//        log.error("Stopped by the interruption in cancellation.");
//        withCancellation.cancel(t);
//      }
      return multipleCoinsRequest
          .flatMapMany(request -> coinsService.findCoinDetailsForMultipleSymbols(request.getNamesList()));

    } catch (Exception e) {
      log.error("Stopped by the interruption");
    }
    return null;
  }

}
