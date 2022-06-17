# jv-getopt - getopt library for Java

## Using in a project
To use jv-getopt in your Java project:
1. Copy git folder to root directory of source code in your project
2. If your IDE doesn't want to compile this class or you don't use IDE, you need to compile Options class manually:


        javac git/Zapomnij/getopt/Options.java


3. To use Options class in your project, place that in the head of Java source code file


        import git.Zapomnij.getopt.*


4. To learn how to use jv-getopt, look into the doc/Example.java

## Packaging class to JAR file
If you want to distribute Options class in your project via JAR file, use command:

    # Compile class
    javac git/Zapomnij/getopt/Options.java

    # Create JAR package with Options.class
    jar -cvf getopt.jar git/Zapomnij/getopt/Options.class

    # Delete old class
    rm git/Zapomnij/getopt/Options.class

## Attaching JAR from releases tab
If you don't want to compile manually this library, download JAR file from releases and:
- If you use Java-dedicated IDE, just add this library by built-in IDE functions.
- If you don't use Java-dedicated IDE:
 - To attach this library to JAR program: put getopt JAR archive in the root of JAR program and place that in the manifest:


        Class-Path: getopt-[getopt version which you use].jar


 - To attach JAR in project which uses a class directory: put getopt JAR archive in the root of classpath and execute command:


        java -classpath [classpath]:[classpath]/getopt-[getopt version which you use].jar
