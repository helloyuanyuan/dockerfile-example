ARG BUILD_IMAGE=openjdk:11.0.7-jdk-slim
ARG RUNTIME_IMAGE=openjdk:11.0.7-jre-slim

FROM ${BUILD_IMAGE} as builder
WORKDIR /app
COPY . .
RUN ./mvnw -B clean package

FROM ${RUNTIME_IMAGE}
WORKDIR /app
COPY --from=builder /root/.m2 /root/.m2
COPY --from=builder /app/.mvn ./.mvn
COPY --from=builder /app/target ./target
COPY --from=builder /app/mvnw /app/mvnw.cmd /app/pom.xml ./
CMD [ "/bin/bash" ]
