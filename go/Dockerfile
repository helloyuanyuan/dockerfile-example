ARG BUILD_IMAGE=golang:1.19.1-alpine3.16
ARG RUNTIME_IMAGE=alpine:latest

FROM ${BUILD_IMAGE} as builder
WORKDIR /app
COPY . .
RUN go build \
&& chmod 777 dockerfile-example-go

FROM ${RUNTIME_IMAGE}
WORKDIR /app
COPY --from=builder /app/dockerfile-example-go .
CMD [ "/bin/sh" ]