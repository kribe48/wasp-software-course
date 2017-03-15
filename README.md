# wasp-software-course
Code for Assignment 2 in the WASP software engineering and cloud computing course.
Kristoffer Bergman and Per Boström

# wasp-software-course

This repository contains code for Assignment 2 in the WASP software engineering and cloud computing course with
  *  Some Java source code, see ```src/main/java```
  *  Some JUnit tests, see ```src/test/java```
  *  An Ant build file with targets for ```build```, ```test```, ```jar```, and ```clean```. See ```build.xml```.
  *  The source files are organized according to the Maven standard directory layout. See https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html .This facilitates integration with other tools, like the Continuous Integration tool Travis.
  *  We don't use any dependencies to download libraries. Instead, all dependent libraries are in included in the project in the ```lib``` folder.


#Installation
To run this project, you need to have Java and Ant installed.
Do
  * ```ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"``` to install homebrew package manager
  * ```brew install ant``` to install ant

#Build
Do
  *  ```ant``` to compile
  *  ```ant test``` to additionally run all tests
  *  ```ant jar``` to generate a Product.jar file
  *  ```ant clean``` to clean away generated files.

#Run
Run the generated jar file by:
  *  ```java -jar Product.jar```
