source_files =$(wildcard calculator/*.java math/*.java)
jar_name = CalQl8r.jar
main_class = calculator.Main

class_files = $(source_files:%.java=%.class)

.PHONY: all clean

all: $(source_files)
	javac -Werror $(source_files)
	jar -c -f $(jar_name) --main-class $(main_class) .

clean:
	rm $(class_files)
	rm $(jar_name)
