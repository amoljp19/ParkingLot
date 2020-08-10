#!/bin/sh
gradle clean fatJar
java -jar build/libs/parking_lot-1.0-SNAPSHOT.jar $1
