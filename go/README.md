# Build & Push & Run

## Docker Build Command

### linux/amd64

~~~bash
docker build -t helloyuanyuan/dockerfile-example-go:amd64 --platform linux/amd64 .
docker push helloyuanyuan/dockerfile-example-go:amd64
docker run --rm -it --name dockerfile-example-go-amd64 helloyuanyuan/dockerfile-example-go:amd64 ./dockerfile-example-go
~~~

### linux/arm64

~~~bash
docker build -t helloyuanyuan/dockerfile-example-go:arm64 --platform linux/arm64 .
docker push helloyuanyuan/dockerfile-example-go:arm64
docker run --rm -it --name dockerfile-example-go-arm64 helloyuanyuan/dockerfile-example-go:arm64 ./dockerfile-example-go
~~~

## Docker Buildx Command

### build local image

docker buildx build -t helloyuanyuan/dockerfile-example-go:local --platform=linux/arm64 . --load
docker push helloyuanyuan/dockerfile-example-go:local
docker run --rm -it --name dockerfile-example-go helloyuanyuan/dockerfile-example-go:local ./dockerfile-example-go

### build and push

docker buildx build -t helloyuanyuan/dockerfile-example-go:v1 --platform=linux/arm64,linux/amd64 . --push
docker run --rm -it --name dockerfile-example-go helloyuanyuan/dockerfile-example-go:v1 ./dockerfile-example-go
