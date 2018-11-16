JC = javac
RM = rm -rf
J = java

CLASSES = dominio/classes
JSON = dominio/JSON
PARSER = dominio/JSON/parser

default: class

class:
	$(JC) $(CLASSES)/*.java $(JSON)/*.java $(PARSER)/*.java

run:
	$(J) $(CLASSES)/Main

clean:
	$(RM) $(CLASSES)/*.class $(JSON)/*.class $(PARSER)/*.class
