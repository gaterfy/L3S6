CC = gcc
JC = javac
CFLAGS = -ansi -Wall -pedantic

all : compile
DNSsimple : DNSsimple.c
	$(CC) $(CFLAGS) $? -o $@

compile:
	javac src/dns/*.java -d ../classes


DNSsimple.class : DNSsimple.java
	$(JC) $?

clean :
	rm -f DNSsimple DNSsimple.class
