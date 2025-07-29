FROM ubuntu:24.04
LABEL org.opencontainers.image.authors="jecklgamis@gmail.com"

RUN apt update -y && apt install -y openjdk-21-jre-headless && rm -rf /var/lib/apt/lists/*

RUN groupadd -r app && useradd -r -gapp app
ENV APP_HOME=/app
RUN mkdir -p $APP_HOME/bin
COPY target/armeria-rest-example.jar $APP_HOME/bin
RUN chown -R app:app $APP_HOME

EXPOSE 8080

WORKDIR $APP_HOME
COPY docker-entrypoint.sh /
RUN chmod +x /docker-entrypoint.sh
CMD ["/docker-entrypoint.sh"]

