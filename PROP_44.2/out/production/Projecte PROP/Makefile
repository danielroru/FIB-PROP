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
	$(J) $(DOMINIO)/Main

clean:
	$(RM) Dominio/*.class JSON/*.class
