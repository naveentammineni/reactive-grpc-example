#!/bin/sh
set -e

DEFAULT_JAVA_OPTIONS="-Djava.security.egd=file:/dev/./urandom -XX:+UseG1GC -XX:+HeapDumpOnOutOfMemoryError"

COMMAND="java ${DEFAULT_JAVA_OPTIONS} ${JAVA_OPTIONS} ${RUN_OPTIONS} -jar ${JAR_FILE}"

echo "Running: ${COMMAND}"

exec ${COMMAND}