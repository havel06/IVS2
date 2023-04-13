calculator_source=$(wildcard calculator/*.java)
math_source=$(wildcard math/*.java)
jar_name = CalQl8r.jar
main_class = calculator.Main
build_dir = build

ifeq ($(CALCULATOR_DEBUG),1)
javac_flags = -encoding utf8 -Werror -g
else
javac_flags = -encoding utf8 -Werror
endif

junit_lib = vendor/junit-4.13.2.jar
hamcrest_lib = vendor/hamcrest-2.2.jar
test_source = $(wildcard tests/*.java)
test_main_class = tests.Main
test_jar_name = tests.jar

profiling_source = profiling/Profiling.java
profiling_jar_name = stddev.jar
profiling_main_class = profiling.Profiling

calculator_classes = $(calculator_source:%.java=%.class)
math_classes = $(math_source:%.java=%.class)
class_files = $(calculator_classes) $(math_classes)

calculator_classes_in_build = $(foreach class, $(calculator_classes), $(build_dir)/$(class))
math_classes_in_build = $(foreach class, $(math_classes), $(build_dir)/$(class))

.PHONY: all clean run test calculator doc profile pack

all: calculator profile

$(calculator_classes_in_build): $(build_dir)/%.class: %.java
	javac $(javac_flags) -d $(build_dir) --module-path vendor --add-modules=javafx.controls,javafx.fxml $<

$(math_classes_in_build): $(build_dir)/%.class: %.java
	javac $(javac_flags) -d $(build_dir) $<

calculator : $(build_dir)/$(jar_name)

$(build_dir)/$(jar_name): $(calculator_classes_in_build) $(math_classes_in_build) calculator.fxml
	cd $(build_dir) && jar -c -f $(jar_name) -m ../calculator_manifest.txt --main-class $(main_class) calculator math ../calculator.fxml
	cp vendor/javafx.base.jar build/javafx.base.jar
	cp vendor/javafx.controls.jar build/javafx.controls.jar
	cp vendor/javafx.graphics.jar build/javafx.graphics.jar
	cp vendor/javafx.fxml.jar build/javafx.fxml.jar

test: $(math_classes_in_build)
	javac $(javac_flags) -d $(build_dir) --module-path vendor --add-modules=junit $(test_source)
	cd $(build_dir) && jar -c -f $(test_jar_name) -m ../test_manifest.txt --main-class $(test_main_class) tests math
	cp $(junit_lib) build/junit.jar
	cp $(hamcrest_lib) build/hamcrest.jar
	cd $(build_dir) && java -jar $(test_jar_name)

profile: $(profiling_source) $(math_classes_in_build)
	javac $(javac_flags) -d $(build_dir) $(profiling_source)
	cd $(build_dir) && jar -c -f $(profiling_jar_name) --main-class $(profiling_main_class) profiling math

clean:
	rm -rf $(build_dir)
	rm -rf doc

run: calculator
	cd $(build_dir) && java -jar $(jar_name)

doc:
	doxygen

pack: calculator profile doc
	#calculator TODO - license, dependencies
	mkdir -p /tmp/calql8r/install/calql8r_1.0/usr/share/CalQl8r/
	mkdir -p /tmp/calql8r/install/calql8r_1.0/usr/bin
	mkdir -p /tmp/calql8r/install/calql8r_1.0/DEBIAN
	cp build/CalQl8r.jar /tmp/calql8r/install/calql8r_1.0/usr/share/CalQl8r/CalQl8r.jar
	cp build/javafx.base.jar /tmp/calql8r/install/calql8r_1.0/usr/share/CalQl8r/javafx.base.jar
	cp build/javafx.controls.jar /tmp/calql8r/install/calql8r_1.0/usr/share/CalQl8r/javafx.controls.jar
	cp build/javafx.fxml.jar /tmp/calql8r/install/calql8r_1.0/usr/share/CalQl8r/javafx.fxml.jar
	cp build/javafx.graphics.jar /tmp/calql8r/install/calql8r_1.0/usr/share/CalQl8r/javafx.graphics.jar
	cp runners/run_calc.sh /tmp/calql8r/install/calql8r_1.0/usr/bin/CalQl8r
	chmod +x /tmp/calql8r/install/calql8r_1.0/usr/bin/CalQl8r
	cp debian_control_calc /tmp/calql8r/install/calql8r_1.0/DEBIAN/control
	cd /tmp/calql8r/install/ && dpkg-deb --build --root-owner-group calql8r_1.0
	rm -rf /tmp/calql8r/install/calql8r_1.0
	#stddev TODO - license, dependencies
	mkdir -p /tmp/calql8r/install/stddev_1.0/usr/share/stddev/
	mkdir -p /tmp/calql8r/install/stddev_1.0/usr/bin
	mkdir -p /tmp/calql8r/install/stddev_1.0/DEBIAN
	cp build/stddev.jar /tmp/calql8r/install/stddev_1.0/usr/share/stddev/stddev.jar
	cp runners/run_stddev.sh /tmp/calql8r/install/stddev_1.0/usr/bin/stddev
	chmod +x /tmp/calql8r/install/stddev_1.0/usr/bin/stddev
	cp debian_control_stddev /tmp/calql8r/install/stddev_1.0/DEBIAN/control
	cd /tmp/calql8r/install/ && dpkg-deb --build --root-owner-group stddev_1.0
	rm -rf /tmp/calql8r/install/stddev_1.0
	#doc
	cp -r doc /tmp/calql8r/doc
	#repo
	make clean
	cp -rf ../ /tmp/calql8r/repo
	#archive
	cd /tmp/calql8r && zip -r archive.zip *
	mv /tmp/calql8r/archive.zip xhavli65_xsemor01_xsitar06.zip
	rm -rf /tmp/calql8r
