all:
	mkdir -p bin
	find -name "*.java" > source.txt
	javac -d bin @source.txt
	rm -f source.txt
