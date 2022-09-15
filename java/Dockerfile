ARG BUILD_IMAGE=openjdk:11.0.7-jdk-slim
ARG RUNTIME_IMAGE=openjdk:11.0.7-jdk-slim
# ARG RUNTIME_IMAGE=openjdk:11.0.7-jre-slim

FROM ${BUILD_IMAGE} as builder
WORKDIR /app
COPY . .
RUN ./buildtest.sh dev bvt

FROM ${RUNTIME_IMAGE}
WORKDIR /app
COPY . .
COPY --from=builder /root/.m2 /root/.m2
CMD [ "/bin/bash" ]
