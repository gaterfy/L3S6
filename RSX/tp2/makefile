CC = gcc
JC = javac
CFLAGS = -ansi -Wall -pedantic

all : DNSsimple DNSsimple.class

DNSsimple : DNSsimple.c
	$(CC) $(CFLAGS) $? -o $@

DNSsimple.class : DNSsimple.java
	$(JC) $?

clean :
	rm -f DNSsimple DNSsimple.class 
