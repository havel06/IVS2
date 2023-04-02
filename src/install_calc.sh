#!/bin/sh

mkdir -p ~/.local/share/CalQl8r
mkdir -p ~/.local/bin

cp build/CalQl8r.jar ~/.local/share/CalQl8r/CalQl8r.jar
cp build/javafx.base.jar ~/.local/share/CalQl8r/javafx.base.jar
cp build/javafx.controls.jar ~/.local/share/CalQl8r/javafx.controls.jar
cp build/javafx.fxml.jar ~/.local/share/CalQl8r/javafx.fxml.jar
cp build/javafx.graphics.jar ~/.local/share/CalQl8r/javafx.graphics.jar

cp run_calc.sh ~/.local/bin/CalQl8r
chmod +x ~/.local/bin/CalQl8r
