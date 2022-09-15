# Getting Started

## Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.3/maven-plugin/reference/html/)

## Project Notes

Make sure code be formatted via google style before commit:

  ~~~bash
  ./mvnw com.coveo:fmt-maven-plugin:format
  ~~~

Run test and generates test report:

  ~~~bash
  ./mvnw clean compile test -Dgroups="bvt, reg" allure:serve
  ~~~

  or

  ~~~bash
  ./buildtest.sh ${env} ${tags}

  Example:

  ./buildtest.sh local bvt1,bvt2,bvt3
  ~~~

## Lifecycle

### Docker build - linux/amd64 - Build & Push & Run

~~~bash
docker build -t helloyuanyuan/dockerfile-example-java:amd64 --platform linux/amd64 .
docker push helloyuanyuan/dockerfile-example-java:amd64
docker run --rm -it --name dockerfile-example-java-amd64 helloyuanyuan/dockerfile-example-java:amd64 ./buildtest.sh qa bvt,reg
~~~

### Docker build - linux/arm64 - Build & Push & Run

~~~bash
docker build -t helloyuanyuan/dockerfile-example-java:arm64 --platform linux/arm64 .
docker push helloyuanyuan/dockerfile-example-java:arm64
docker run --rm -it --name dockerfile-example-java-arm64 helloyuanyuan/dockerfile-example-java:arm64 ./buildtest.sh qa bvt,reg
~~~

### Docker buildx - linux/amd64 - Build & Push & Run

~~~bash
docker buildx build -t helloyuanyuan/dockerfile-example-java:amd64 --platform=linux/amd64 . --load
docker push helloyuanyuan/dockerfile-example-java:amd64
docker run --rm -it --name dockerfile-example-java helloyuanyuan/dockerfile-example-java:amd64 ./buildtest.sh qa bvt,reg
~~~

### Docker buildx - linux/arm64 - Build & Push & Run

~~~bash
docker buildx build -t helloyuanyuan/dockerfile-example-java:arm64 --platform=linux/arm64 . --load
docker push helloyuanyuan/dockerfile-example-java:arm64
docker run --rm -it --name dockerfile-example-java helloyuanyuan/dockerfile-example-java:arm64 ./buildtest.sh qa bvt,reg
~~~

### Docker buildx - linux/amd64,linux/arm64 - Push & Run

~~~bash
docker buildx build -t helloyuanyuan/dockerfile-example-java:v1 --platform=linux/amd64,linux/arm64 . --push
docker run --rm -it --name dockerfile-example-java helloyuanyuan/dockerfile-example-java:v1 ./buildtest.sh qa bvt,reg
~~~
