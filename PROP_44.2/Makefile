CLASSES = src/dominio/classes
CONTROLADORES = src/dominio/controladores
VISTES = src/presentacio
VISTES2 = src/presentacio/CarregarDades
VISTES3 = src/presentacio/EditarDades
VISTES4 = src/presentacio/GestionarHoraris


default: class

class:
	javac -cp src/persistencia/gson-2.6.2.jar -d bin $(CLASSES)/*.java $(CONTROLADORES)/*.java $(VISTES)/*.java $(VISTES2)/*.java $(VISTES3)/*.java $(VISTES4)/*.java

jar:
	jar cvf GeneradorHorari2.jar -C bin/dominio/classes .

runjar:
	java -jar GeneradorHorari.jar

run:
	java -cp src/persistencia/gson-2.6.2.jar:bin  dominio.classes.Main

clean:
	rm -rf bin/dominio
