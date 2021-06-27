#!/bin/bash

sbt clean compile dist
docker build --no-cache -t data-filtrator .
docker-compose up