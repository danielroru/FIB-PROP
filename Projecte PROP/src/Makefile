JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
		Main.java \

default: classes

classes: javac Dominio/*.java JSON/*.javac

run: java Dominio/Main

clean:
		$(RM) *.class
