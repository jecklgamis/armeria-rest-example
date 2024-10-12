IMAGE_NAME:=armeria-rest-example
IMAGE_TAG:=main

default:
	cat ./Makefile
dist:
	./mvnw clean package
image:
	docker build -t $(IMAGE_NAME):$(IMAGE_TAG) .
run:
	docker run -p 8080:8080 $(IMAGE_NAME):$(IMAGE_TAG)
run-shell:
	docker run -i -t $(IMAGE_NAME):$(IMAGE_TAG) /bin/bash
all: dist image
up: all run
