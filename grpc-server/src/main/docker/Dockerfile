FROM azul/zulu-openjdk-alpine:11.0.3-jre

RUN echo 'hosts: files mdns4_minimal [NOTFOUND=return] dns mdns4' >> /etc/nsswitch.conf

ARG JAR_FILE
ARG RUN_OPTIONS=''

ENV JAR_FILE=${JAR_FILE} RUN_OPTIONS=${RUN_OPTIONS}

WORKDIR /opt

ADD ${JAR_FILE} run-java.sh ./

ENTRYPOINT [ "./run-java.sh" ]
