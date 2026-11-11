## Armeria Rest Example

[![Build](https://github.com/jecklgamis/armeria-rest-example/actions/workflows/build.yaml/badge.svg)](https://github.com/jecklgamis/armeria-rest-example/actions/workflows/build.yaml)

This is an example Armeria REST app using Java.

Docker: `docker run -p 8080:8080 -it jecklgamis/armeria-rest-example:main`


## Requirements

* Java 25, Docker

## Running

Using executable jar:
```bash
./mvnw clean package
java -jar target/armeria-rest-example.jar
```

Using Docker:
```bash
docker build -t armeria-rest-example:main .
docker run -it armeria-rest-example:main
```

## Load Testing

Load tests use [resonate](https://github.com/jecklgamis/resonate). With the app running:

```bash
brew install jecklgamis/tap/resonate
./run-perf-tests.sh
```
See [perf-tests](perf-tests) for the scenarios and details.
