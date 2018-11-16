JC = javac
RM = rm -rf
J = java
CLASSES = src/dominio/classes
PERSISTENCIA = src/persistencia
JSON = src/dominio/json
default: class

class:
	$(JC) $(CLASSES)/*.java $(JSON)/*.java

run:
	$(J) $(DOMINIO)/Main

clean:
	$(RM) Dominio/*.class JSON/*.class
