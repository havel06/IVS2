calculator_source=$(wildcard calculator/*.java)
math_source=$(wildcard math/*.java)
jar_name = CalQl8r.jar
main_class = calculator.Main
build_dir = build

javafx_lib = vendor/javafx.base.jar:vendor/javafx.controls.jar:vendor/javafx.graphics.jar:vendor/javafx-swt.jar:vendor/javafx.fxml.jar:vendor/javafx.media.jar:vendor/javafx.swing.jar

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

.PHONY: all clean run test calculator doc profiling

all: $(build_dir)/$(jar_name) profiling

$(calculator_classes_in_build): $(build_dir)/%.class: %.java
	javac -encoding utf8 -d $(build_dir) --module-path vendor --add-modules=javafx.controls,javafx.fxml -Werror $<

$(math_classes_in_build): $(build_dir)/%.class: %.java
	javac -encoding utf8 -d $(build_dir) --module-path vendor --add-modules=javafx.controls,javafx.fxml -Werror $<

$(build_dir)/$(jar_name): $(calculator_classes_in_build) $(math_classes_in_build)
	cp calculator.fxml build/calculator.fxml
	cd $(build_dir) && jar -c -f $(jar_name) -m ../calculator_manifest.txt --main-class $(main_class) calculator math calculator.fxml
	cp vendor/javafx.base.jar build/javafx.base.jar
	cp vendor/javafx.controls.jar build/javafx.controls.jar
	cp vendor/javafx.graphics.jar build/javafx.graphics.jar
	cp vendor/javafx-swt.jar build/javafx-swt.jar
	cp vendor/javafx.fxml.jar build/javafx.fxml.jar
	cp vendor/javafx.media.jar build/javafx.media.jar
	cp vendor/javafx.swing.jar build/javafx.swing.jar

test: $(math_classes_in_build)
	javac -encoding utf8 -d $(build_dir) -Werror -cp "$(junit_lib):build/" $(test_source)
	cd $(build_dir) && jar -c -f $(test_jar_name) -m ../test_manifest.txt --main-class $(test_main_class) .
	cp $(junit_lib) build/junit.jar
	cp $(hamcrest_lib) build/hamcrest.jar
	cd $(build_dir) && java -jar $(test_jar_name)

profiling: $(profiling_source)
	javac -encoding utf8 -d $(build_dir) -Werror $(profiling_source)
	cd $(build_dir) && jar -c -f $(profiling_jar_name) --main-class $(profiling_main_class) profiling

clean:
	rm -r $(build_dir)

run: $(build_dir)/$(jar_name)
	cd $(build_dir) && java -jar $(jar_name)

doc:
	doxygen
