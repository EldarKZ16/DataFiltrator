FROM openjdk:8-alpine

RUN apk add --no-cache bash

RUN mkdir -p /app/resources
COPY ./src/main/resources/* /app/resources/

WORKDIR /app
COPY ./target/universal/data-filtrator-0.0.1.zip /app/
RUN unzip -q data-filtrator-0.0.1.zip
RUN rm /app/data-filtrator-0.0.1.zip

WORKDIR /app/data-filtrator-0.0.1/bin
CMD chmod +x data-filtrator

CMD ["/bin/bash", "-c", "./data-filtrator"]