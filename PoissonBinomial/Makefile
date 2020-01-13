JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-11.0.1.jdk/Contents/Home
CC=g++
CFLAGS=-std=c++11 -I"$(JAVA_HOME)/include" -I"$(JAVA_HOME)/include/darwin" -I"/usr/local/include -L"/usr/local/lib/""
LDFLAGS=-dynamiclib -lfftw3 -lm

SOURCES_DIR=src/main/cpp
OBJECTS_DIR=src/main/resources/lib
LIBRARY=libpoissonbinomial.dylib

SOURCES=$(shell find '$(SOURCES_DIR)' -type f -name '*.cpp')
OBJECTS=$(SOURCES:$(SOURCES_DIR)/%.cpp=$(OBJECTS_DIR)/$(LIBRARY))

all: $(OBJECTS)

$(OBJECTS): $(SOURCES)
	mkdir -p $(OBJECTS_DIR)
	$(CC) $(LDFLAGS) $(CFLAGS) $< -o $@

clean:
	rm -rf $(OBJECTS_DIR) $(EXECUTABLE)


