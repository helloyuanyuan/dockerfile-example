# Getting Started

## Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.3/maven-plugin/reference/html/)

## Note

Make sure code be formatted via google style before commit:

  ~~~bash
  ./mvnw com.coveo:fmt-maven-plugin:format
  ~~~

Run test and generates test report:

  ~~~bash
  ./mvnw clean compile test -Dgroups="bvt, reg" allure:serve
  ~~~
