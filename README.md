## Armeria Rest Example

[![Build](https://github.com/jecklgamis/armeria-rest-example/actions/workflows/build.yml/badge.svg)](https://github.com/jecklgamis/armeria-rest-example/actions/workflows/build.yml)

This is an example Armeria REST app using Java.

Docker: `docker run -p 8080:8080 -it jecklgamis/armeria-rest-example:main`


## Requirements

* Java 21, Docker

## Running

Using executable jar
```bash
./mvnw clean package
java -jar target/armeria-rest-example.jar
```

Using Docker:
```bash
docker build -t armeria-rest-example:main
docker run -it armeria-rest-example:main
```