#!/bin/bash

sbt clean compile test dist
docker build --no-cache -t data-filtrator .
docker rmi `docker images --filter dangling=true -q` # remove all dangling images, which has no pointer
docker-compose up
docker-compose down -v # remove docker-compose image