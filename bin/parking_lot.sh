#!/bin/sh
gradle clean fatJar
java -jar build/libs/ParkingLot-1.0-SNAPSHOT.jar $1
