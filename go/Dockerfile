FROM golang:1.19.1-alpine3.16 as builder
WORKDIR /app
COPY . .
RUN go build \
&& chmod 777 dockerfile-example-go

FROM alpine:latest
WORKDIR /app
COPY --from=builder /app/dockerfile-example-go .
CMD [ "/bin/sh" ]