CLASSES = src/dominio/classes
JSON = src/dominio/JSON
PARSER = src/dominio/JSON/parser

default: class

class:
	javac -cp src -d bin $(CLASSES)/*.java $(JSON)/*.java $(PARSER)/*.java

run:
	java -classpath bin dominio.classes.Main

clean:
	rm -rf bin/dominio
