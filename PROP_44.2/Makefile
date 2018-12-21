CLASSES = src/dominio/classes
CONTROLADORES = src/dominio/controladores
VISTES = src/presentacio
VISTES2 = src/presentacio/CarregarDades
VISTES3 = src/presentacio/EditarDades
VISTES4 = src/presentacio/GestionarHoraris


default: class

class:
	javac -cp src -classpath src/persistencia/gson-2.6.3.jar -d bin $(CLASSES)/*.java $(CONTROLADORES)/*.java $(VISTES)/*.java $(VISTES2)/*.java $(VISTES3)/*.java $(VISTES4)/*.java

test:
	javac -Xlint:unchecked -cp src/persistencia/gson-2.6.2.jar -d bin $(CLASSES)/*.java $(CONTROLADORES)/*.java $(VISTES)/*.java $(VISTES2)/*.java $(VISTES3)/*.java $(VISTES4)/*.java

run:
	java -cp bin ../src/persistencia/gson-2.6.2.jar dominio.classes.Main

clean:
	rm -rf bin/dominio
