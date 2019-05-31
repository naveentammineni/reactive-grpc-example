package com.example.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.21.0)",
    comments = "Source: crypto/crypto-coins.proto")
public final class CryptoCoinsServiceGrpc {

  private CryptoCoinsServiceGrpc() {}

  public static final String SERVICE_NAME = "crypto.CryptoCoinsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.proto.CoinSymbol,
      com.example.proto.CoinInfo> getGetCoinPriceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCoinPrice",
      requestType = com.example.proto.CoinSymbol.class,
      responseType = com.example.proto.CoinInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.proto.CoinSymbol,
      com.example.proto.CoinInfo> getGetCoinPriceMethod() {
    io.grpc.MethodDescriptor<com.example.proto.CoinSymbol, com.example.proto.CoinInfo> getGetCoinPriceMethod;
    if ((getGetCoinPriceMethod = CryptoCoinsServiceGrpc.getGetCoinPriceMethod) == null) {
      synchronized (CryptoCoinsServiceGrpc.class) {
        if ((getGetCoinPriceMethod = CryptoCoinsServiceGrpc.getGetCoinPriceMethod) == null) {
          CryptoCoinsServiceGrpc.getGetCoinPriceMethod = getGetCoinPriceMethod = 
              io.grpc.MethodDescriptor.<com.example.proto.CoinSymbol, com.example.proto.CoinInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "crypto.CryptoCoinsService", "GetCoinPrice"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.proto.CoinSymbol.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.proto.CoinInfo.getDefaultInstance()))
                  .setSchemaDescriptor(new CryptoCoinsServiceMethodDescriptorSupplier("GetCoinPrice"))
                  .build();
          }
        }
     }
     return getGetCoinPriceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.proto.CoinSymbols,
      com.example.proto.CoinInfo> getGetMultipleCoinsPriceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMultipleCoinsPrice",
      requestType = com.example.proto.CoinSymbols.class,
      responseType = com.example.proto.CoinInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.proto.CoinSymbols,
      com.example.proto.CoinInfo> getGetMultipleCoinsPriceMethod() {
    io.grpc.MethodDescriptor<com.example.proto.CoinSymbols, com.example.proto.CoinInfo> getGetMultipleCoinsPriceMethod;
    if ((getGetMultipleCoinsPriceMethod = CryptoCoinsServiceGrpc.getGetMultipleCoinsPriceMethod) == null) {
      synchronized (CryptoCoinsServiceGrpc.class) {
        if ((getGetMultipleCoinsPriceMethod = CryptoCoinsServiceGrpc.getGetMultipleCoinsPriceMethod) == null) {
          CryptoCoinsServiceGrpc.getGetMultipleCoinsPriceMethod = getGetMultipleCoinsPriceMethod = 
              io.grpc.MethodDescriptor.<com.example.proto.CoinSymbols, com.example.proto.CoinInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "crypto.CryptoCoinsService", "GetMultipleCoinsPrice"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.proto.CoinSymbols.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.proto.CoinInfo.getDefaultInstance()))
                  .setSchemaDescriptor(new CryptoCoinsServiceMethodDescriptorSupplier("GetMultipleCoinsPrice"))
                  .build();
          }
        }
     }
     return getGetMultipleCoinsPriceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CryptoCoinsServiceStub newStub(io.grpc.Channel channel) {
    return new CryptoCoinsServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CryptoCoinsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CryptoCoinsServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CryptoCoinsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CryptoCoinsServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CryptoCoinsServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getCoinPrice(com.example.proto.CoinSymbol request,
        io.grpc.stub.StreamObserver<com.example.proto.CoinInfo> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCoinPriceMethod(), responseObserver);
    }

    /**
     * <pre>
     *rpc with deadline
     * </pre>
     */
    public void getMultipleCoinsPrice(com.example.proto.CoinSymbols request,
        io.grpc.stub.StreamObserver<com.example.proto.CoinInfo> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMultipleCoinsPriceMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetCoinPriceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.proto.CoinSymbol,
                com.example.proto.CoinInfo>(
                  this, METHODID_GET_COIN_PRICE)))
          .addMethod(
            getGetMultipleCoinsPriceMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.example.proto.CoinSymbols,
                com.example.proto.CoinInfo>(
                  this, METHODID_GET_MULTIPLE_COINS_PRICE)))
          .build();
    }
  }

  /**
   */
  public static final class CryptoCoinsServiceStub extends io.grpc.stub.AbstractStub<CryptoCoinsServiceStub> {
    private CryptoCoinsServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CryptoCoinsServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CryptoCoinsServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CryptoCoinsServiceStub(channel, callOptions);
    }

    /**
     */
    public void getCoinPrice(com.example.proto.CoinSymbol request,
        io.grpc.stub.StreamObserver<com.example.proto.CoinInfo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCoinPriceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *rpc with deadline
     * </pre>
     */
    public void getMultipleCoinsPrice(com.example.proto.CoinSymbols request,
        io.grpc.stub.StreamObserver<com.example.proto.CoinInfo> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetMultipleCoinsPriceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CryptoCoinsServiceBlockingStub extends io.grpc.stub.AbstractStub<CryptoCoinsServiceBlockingStub> {
    private CryptoCoinsServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CryptoCoinsServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CryptoCoinsServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CryptoCoinsServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.proto.CoinInfo getCoinPrice(com.example.proto.CoinSymbol request) {
      return blockingUnaryCall(
          getChannel(), getGetCoinPriceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *rpc with deadline
     * </pre>
     */
    public java.util.Iterator<com.example.proto.CoinInfo> getMultipleCoinsPrice(
        com.example.proto.CoinSymbols request) {
      return blockingServerStreamingCall(
          getChannel(), getGetMultipleCoinsPriceMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CryptoCoinsServiceFutureStub extends io.grpc.stub.AbstractStub<CryptoCoinsServiceFutureStub> {
    private CryptoCoinsServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CryptoCoinsServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CryptoCoinsServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CryptoCoinsServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.proto.CoinInfo> getCoinPrice(
        com.example.proto.CoinSymbol request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCoinPriceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_COIN_PRICE = 0;
  private static final int METHODID_GET_MULTIPLE_COINS_PRICE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CryptoCoinsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CryptoCoinsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_COIN_PRICE:
          serviceImpl.getCoinPrice((com.example.proto.CoinSymbol) request,
              (io.grpc.stub.StreamObserver<com.example.proto.CoinInfo>) responseObserver);
          break;
        case METHODID_GET_MULTIPLE_COINS_PRICE:
          serviceImpl.getMultipleCoinsPrice((com.example.proto.CoinSymbols) request,
              (io.grpc.stub.StreamObserver<com.example.proto.CoinInfo>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CryptoCoinsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CryptoCoinsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.proto.CryptoCoins.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CryptoCoinsService");
    }
  }

  private static final class CryptoCoinsServiceFileDescriptorSupplier
      extends CryptoCoinsServiceBaseDescriptorSupplier {
    CryptoCoinsServiceFileDescriptorSupplier() {}
  }

  private static final class CryptoCoinsServiceMethodDescriptorSupplier
      extends CryptoCoinsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CryptoCoinsServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CryptoCoinsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CryptoCoinsServiceFileDescriptorSupplier())
              .addMethod(getGetCoinPriceMethod())
              .addMethod(getGetMultipleCoinsPriceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
