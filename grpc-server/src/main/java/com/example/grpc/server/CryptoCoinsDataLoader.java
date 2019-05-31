package com.example.grpc.server;

import com.example.proto.CoinInfo;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CryptoCoinsDataLoader implements ApplicationRunner {

  private Map<String, CoinDetails> coinDetailsMap = new HashMap<>();

  @Override
  public void run(ApplicationArguments args) throws Exception {

    JSONParser parser = new JSONParser();

    File file = new File(
        getClass().getClassLoader().getResource("coins.json").getFile()
    );

    try (FileReader reader = new FileReader(file)) {

      Object obj = parser.parse(reader);
      JSONObject jsonObject = (JSONObject) obj;
      JSONArray dataArray = (JSONArray) jsonObject.get("data");

      for(int i=0; i < dataArray.size(); i++) {

        JSONObject dataObject = (JSONObject) dataArray.get(i);

        String name = (String) dataObject.get("name");
        long id = (Long) dataObject.get("id");
        String symbol = (String) dataObject.get("symbol");
        long cmcRank = (Long) dataObject.get("cmc_rank");
        JSONObject quoteObject = (JSONObject) dataObject.get("quote");
        JSONObject usdObject = (JSONObject) quoteObject.get("USD");
        double coinPrice = (Double) usdObject.get("price");

        CoinDetails coinDetails = CoinDetails.builder()
            .id(id)
            .cmcRank(cmcRank)
            .name(name)
            .price(coinPrice)
            .symbol(symbol)
            .build();
        coinDetailsMap.put(symbol, coinDetails);
      }

      System.out.println("Successfully loaded "+coinDetailsMap.size() + " coins to map");

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public Mono<CoinInfo> getCoinDetails(String coinSymbol) {

    return Mono.just(coinDetailsMap.get(coinSymbol))
        .map(coinDetails -> CoinInfo.newBuilder()
              .setMarketCap(coinDetails.getTotalSupply())
              .setName(coinDetails.getName())
              .setPrice(coinDetails.getPrice())
              .setRank(coinDetails.getCmcRank())
              .setSymbol(coinDetails.getSymbol())
              .build());
  }

}
