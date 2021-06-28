FROM openjdk:8-alpine

ENV UNIVERSAL_ZIP_NAME filtrator.zip
ENV UNIVERSAL_NAME filtrator
ENV SCRIPT data-filtrator

RUN apk add --no-cache bash

RUN mkdir -p /app/resources
COPY ./src/main/resources/* /app/resources/

WORKDIR /app
COPY ./target/universal/$UNIVERSAL_ZIP_NAME /app/
RUN unzip -q $UNIVERSAL_ZIP_NAME
RUN rm /app/$UNIVERSAL_ZIP_NAME

WORKDIR /app/$UNIVERSAL_NAME/bin
CMD chmod +x $SCRIPT

CMD ["/bin/bash", "-c", "./$SCRIPT"]