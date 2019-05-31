package com.example.grpc.server;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoinDetails {

  private long id;
  private String name;
  private String symbol;
  private long totalSupply;
  private long cmcRank;
  private double price;

}
