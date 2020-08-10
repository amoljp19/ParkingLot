#!/bin/sh
sudo apt update
sudo apt install zip
sudo apt install default-jdk
java -version
curl -s https://get.sdkman.io | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk install kotlin
sdk install gradle 6.5.1
sudo chmod 777 -R ../parking_lot
