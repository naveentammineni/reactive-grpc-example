package com.example.grpc.server;

import com.example.proto.CoinInfo;
import com.example.proto.CoinSymbol;
import com.example.proto.CoinSymbols;
import com.example.proto.ReactorCryptoCoinsServiceGrpc;
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

    try {
      return multipleCoinsRequest
          .flatMapMany(request -> coinsService.findCoinDetailsForMultipleSymbols(request.getNamesList()));

    } catch (Exception e) {
      log.error("Stopped by the interruption");
    }
    return null;
  }

}
