package com.example.proto;

import static com.example.proto.CryptoCoinsServiceGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;


@javax.annotation.Generated(
value = "by ReactorGrpc generator",
comments = "Source: crypto/crypto-coins.proto")
public final class ReactorCryptoCoinsServiceGrpc {
    private ReactorCryptoCoinsServiceGrpc() {}

    public static ReactorCryptoCoinsServiceStub newReactorStub(io.grpc.Channel channel) {
        return new ReactorCryptoCoinsServiceStub(channel);
    }

    public static final class ReactorCryptoCoinsServiceStub extends io.grpc.stub.AbstractStub<ReactorCryptoCoinsServiceStub> {
        private CryptoCoinsServiceGrpc.CryptoCoinsServiceStub delegateStub;

        private ReactorCryptoCoinsServiceStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = CryptoCoinsServiceGrpc.newStub(channel);
        }

        private ReactorCryptoCoinsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = CryptoCoinsServiceGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected ReactorCryptoCoinsServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReactorCryptoCoinsServiceStub(channel, callOptions);
        }

        public reactor.core.publisher.Mono<com.example.proto.CoinInfo> getCoinPrice(reactor.core.publisher.Mono<com.example.proto.CoinSymbol> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::getCoinPrice);
        }

        /**
         * <pre>
         * rpc with deadline
         * </pre>
         */
        public reactor.core.publisher.Flux<com.example.proto.CoinInfo> getMultipleCoinsPrice(reactor.core.publisher.Mono<com.example.proto.CoinSymbols> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToMany(reactorRequest, delegateStub::getMultipleCoinsPrice);
        }

        public reactor.core.publisher.Mono<com.example.proto.CoinInfo> getCoinPrice(com.example.proto.CoinSymbol reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::getCoinPrice);
        }

        /**
         * <pre>
         * rpc with deadline
         * </pre>
         */
        public reactor.core.publisher.Flux<com.example.proto.CoinInfo> getMultipleCoinsPrice(com.example.proto.CoinSymbols reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToMany(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::getMultipleCoinsPrice);
        }

    }

    public static abstract class CryptoCoinsServiceImplBase implements io.grpc.BindableService {

        public reactor.core.publisher.Mono<com.example.proto.CoinInfo> getCoinPrice(reactor.core.publisher.Mono<com.example.proto.CoinSymbol> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         * rpc with deadline
         * </pre>
         */
        public reactor.core.publisher.Flux<com.example.proto.CoinInfo> getMultipleCoinsPrice(reactor.core.publisher.Mono<com.example.proto.CoinSymbols> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            com.example.proto.CryptoCoinsServiceGrpc.getGetCoinPriceMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.example.proto.CoinSymbol,
                                            com.example.proto.CoinInfo>(
                                            this, METHODID_GET_COIN_PRICE)))
                    .addMethod(
                            com.example.proto.CryptoCoinsServiceGrpc.getGetMultipleCoinsPriceMethod(),
                            asyncServerStreamingCall(
                                    new MethodHandlers<
                                            com.example.proto.CoinSymbols,
                                            com.example.proto.CoinInfo>(
                                            this, METHODID_GET_MULTIPLE_COINS_PRICE)))
                    .build();
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
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((com.example.proto.CoinSymbol) request,
                            (io.grpc.stub.StreamObserver<com.example.proto.CoinInfo>) responseObserver,
                            serviceImpl::getCoinPrice);
                    break;
                case METHODID_GET_MULTIPLE_COINS_PRICE:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToMany((com.example.proto.CoinSymbols) request,
                            (io.grpc.stub.StreamObserver<com.example.proto.CoinInfo>) responseObserver,
                            serviceImpl::getMultipleCoinsPrice);
                    break;
                default:
                    throw new java.lang.AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new java.lang.AssertionError();
            }
        }
    }

}
