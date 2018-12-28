# A hello-world application for Spring framework and Java 8

# Why
Spring is one of the most popular frameworks for developing Web applications, especially in the Java world. This tutorial describes how to create a hello-world application with [Spring Boot](http://spring.io/projects/spring-boot) and run it on you local Windows machine. I'm always under the impression that Java is one of the languages that requires the most effort to create a running hello-world program. This tutorial tries to mitigate the pain as much as possible. Be aware this tutorial does not attempt to explain Spring/Spring Boot. 

# What
At the end of the tutorial, you should have a running web application with the following behaviors. Note the differences in the url address.

![Root Url](https://github.com/linlichen/TechnicalWriting/blob/master/images/helloworld-java-spring/root.png?raw=true)
![Root Url](https://github.com/linlichen/TechnicalWriting/blob/master/images/helloworld-java-spring/greeting-default.png?raw=true)
![Root Url](https://github.com/linlichen/TechnicalWriting/blob/master/images/helloworld-java-spring/greeting-with-input.png?raw=true)

# Environments and Tools
- OS: Windows 10

- Java 8 JDK
- Maven
- IntelliJ IDEA community (but you can use Whatever IDE you like)

# Installation
## Java 8 JDK
1. Download `jdk-8uxxx-windows-x64.exe` from [Oracle offical site](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html), or just Goolge Java 8 JDK and pick the right link. 
1. Install the downloaded exe. 
1. Create a new Windows environment variable `JAVA_HOME`  to point to your JDK root location, e.g. `C:\Program Files\Java\jdk1.8.0_172`.
1. In Windows Command Prompt, run `echo %JAVA_HOME%` and you should see the JDK location you set in the previous step, e.g. `C:\Program Files\Java\jdk1.8.0_172`

## Maven 
1. Download the latest binary zip archive file from https://maven.apache.org/download.cgi. e.g. Download `apache-maven-3.6.0-bin.zip`
1. Install Maven, which just means to unzip the binary file to your preferred directory. e.g. unzip to `C:\Program Files\Java`
1. Add the Maven `bin` folder, e.g. `C:\Program Files\Java\apache-maven-3.6.0\bin`, to the Windows environment variable `PATH`.
1. In Windows Command Prompt, run `mvn -v` and you should see the Maven version information
	```
	Apache Maven 3.6.0 (97c98ec64a1fdfee7767ce5ffb20918da4f719f3; 2018-10-24T11:41:47-07:00)
	Maven home: C:\Program Files\Java\apache-maven-3.6.0\bin\..
	Java version: 1.8.0_172, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk1.8.0_172\jre
	Default locale: en_US, platform encoding: Cp1252
	OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
  	```


# Source Code
Clone the source code from [this repo](https://github.com/linlichen/helloworld-java-spring). Here's a brief overview of the important files:
* `pom.xml`: This is the project configuration file used by Maven. The dependencies on Spring Boot are defined in this file.
* `src\main\java\com\linlichen\spring\helloworld\Application.java` You can think of this file as a boilerplate for setting up the application. 
* `src\main\java\com\linlichen\spring\helloworld\GreetingController.java` This is the class that defines the behavior when `/greeting` url is requested. 
* `src\main\resources\static\index.html` This static html file is returned when the root url is requested, e.g. if you run the application on your local machine, the content of this file is showed for `http://localhost:8080`
* `src\main\resources\templates\greeting.html` This dynamic html file is used together with `GreetingController.java` to generate the final html output. Basically, the `${locationName}` will be replaced with the value of the `locationName` variable in the `GreetingController.java` 

# Build and Run
- In Windowns Command Prompt or IntelliJ terminal, change directory to the root of the application, and run `mvn spring-boot:run`. It will then start build and deploy your application. Once it has finished, the website will be running at your localhost http://localhost:8080/.
- You can terminate the web server by typing `ctrl-c` in the same command console thread.

# References
- https://spring.io/guides/gs/serving-web-content/
- spring vs spring boot https://dzone.com/articles/understanding-the-basics-of-spring-vs-spring-boot
- how to terminate tomcat server if `ctrl-c` does not work: https://stackoverflow.com/questions/23432651/terminating-mvn-spring-bootrun-doesnt-stop-tomcat