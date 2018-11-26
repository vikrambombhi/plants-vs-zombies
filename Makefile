make:
	javac src/**/*.java -d build/

jar:
	jar -cfm build/plants-vs-zombies.jar Manifest.txt src -C build .

test:
	cd build && java org.junit.runner.JUnitCore test.AllTests

clean:
	rm -r build/*
