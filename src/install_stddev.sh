#!/bin/sh

mkdir -p ~/.local/share/stddev
mkdir -p ~/.local/bin

cp build/stddev.jar ~/.local/share/stddev/stddev.jar

cp run_stddev.sh ~/.local/bin/stddev
chmod +x ~/.local/bin/stddev
