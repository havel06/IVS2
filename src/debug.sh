#!/bin/sh

export CALCULATOR_DEBUG=1
make clean
make
cd build
jdb -sourcepath .. -classpath CalQl8r.jar:javafx.base.jar:javafx.controls.jar:javafx.fxml.jar:javafx.grahpics.jar calculator.Main
