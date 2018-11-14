make:
	javac src/**/*.java -d build/

jar:
	jar -cfm build/plants-vs-zombies.jar Manifest.txt -C build .

clean:
	rm build/*
