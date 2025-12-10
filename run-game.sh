#!/bin/bash

mvn clean package
java -jar target/UVGame-1.0-SNAPSHOT.jar

rm -r target