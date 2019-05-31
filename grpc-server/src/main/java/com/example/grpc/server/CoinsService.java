package com.example.grpc.server;

import com.example.proto.CoinInfo;
import io.grpc.Context;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class CoinsService {

  private final CryptoCoinsDataLoader cryptoCoinsDataLoader;

  public Mono<CoinInfo> getCoinPrice(String coinSymbol) {

    log.info("receiving request for symbol: "+coinSymbol);

    return
        Mono.defer(() -> cryptoCoinsDataLoader.getCoinDetails(coinSymbol));
  }

  public Flux<CoinInfo> findCoinDetailsForMultipleSymbols(List<String> coinSymbols) {

    return Flux.fromIterable(coinSymbols)
        .filter(x -> {
          if(Context.current().isCancelled()) {
            log.info("deadline exceeded at coin: "+ x);
            return false;
          } else {
            return true;
          }
        })
        .doOnNext(s -> log.info("Processing coin: "+ s))
        .flatMap(cryptoCoinsDataLoader::getCoinDetails)
        .doOnNext(coinInfo -> log.info("returning " + coinInfo));
  }
}
