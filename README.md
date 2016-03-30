## JMP 2015-2016

#### Getting Started
- All [gradle](https://gradle.org/) commands should be executed from root folder
- To clean all subprojects from `console` for `*nix` systems: `./gradlew clean`
- To clean all subprojects from `console` for `windows` systems: `gradlew.bat clean`


#### Module 1 : Principle of software development (Micro Benchmark Application)
- To run or build this project from `console` for `*nix` systems: `./gradlew module-01:run` or `./gradlew module-01:build`
- To run or build this project from `console` for `windows` systems: `gradlew.bat module-01:run` or `gradlew.bat module-01:build`
- To run this project from `IDE`: execute `jmp.module01.Main` class with programm arguments `-b jmp.module01.tests.A -b  jmp.module01.tests.B`


#### Module 2 : UML Basics
- Use Case, Component, Package, Sequence, State Machine, Class


#### Module 3 : Creational Patterns (Abstract Factory)
- To run or build this project from `console` for `*nix` systems: `./gradlew module-03:runFileMode` , `./gradlew module-03:runDbMode` or `./gradlew module-03:build`
- To run or build this project from `console` for `windows` systems: `gradlew.bat module-03:runFileMode` , `gradlew.bat module-03:runDbMode` or `gradlew.bat module-03:build`
- To run this project from `IDE`: execute `jmp.module03.Main` class with programm arguments `-source file` or `-source db`


#### Module 4 : Structural Patterns (Adapter)
- To run or build this project from `console` for `*nix` systems: `./gradlew module-04:run` or `./gradlew module-04:build`
- To run or build this project from `console` for `windows` systems: `gradlew.bat module-04:run` or `gradlew.bat module-04:build`
- To run this project from `IDE`: execute `jmp.module04.Main` class


#### Module 5 : Classloading
- To build of application into folder from `console` for `*nix` systems: `./gradlew :module-05/main-project:createApplication`
- To build of application into folder from `console` for `windows` systems: `gradlew.bat :module-05/main-project:createApplication`
- To build of application into folder from `IDE`: run `createApplication` task in `module-05/main-project` project
- After build, go to `{root}/temporary` folder and execute command `java -jar main-project-1.0.0-SNAPSHOT.jar`


#### Module 6 : Memory Management
- To run tests from `IDE`: execute classes from `jmp.module06` packege: `GarbageCollectorActivity` and `HeapOutOfMemoryError`, `PermOutOfMemoryError`, `StackOverflowError` with VM options `-Xss1m -Xmn9m -XX:SurvivorRatio=1 -Xms16m -Xmx16m -XX:PermSize=16m -XX:MaxPermSize=16m`


#### Module 7 : Garbage Collection in Java
- Serial GC, Concurrent Mark Sweep (CMS) GC


#### Module 8 : Multithreading (Classic Model and Concurrency)
- To run or build this project from `console` for `*nix` systems: `./gradlew module-08:run` or `./gradlew module-08:build`
- To run or build this project from `console` for `windows` systems: `gradlew.bat module-08:run` or `gradlew.bat module-08:build`
- To run this project from `IDE`: execute `jmp.module08.Main` class


#### Module 9 : Troubleshooting
- To generate CheckStyle and FindBugs reports from `console` for `*nix` systems: `./gradlew module-09/checkstyle:check` and `./gradlew module-09/findbugs:check`
- To generate CheckStyle and FindBugs reports from `console` for `windows` systems: `gradlew.bat module-09/checkstyle:check` and `gradlew.bat module-09/findbugs:check`
- To generate CheckStyle and FindBugs reports from `IDE`: execute `check` task for `checkstyle` and `findbugs` projects
- After generate, reports will be located in `{root}/module-09/checkstyle/build/reports/checkstyle/checkstyle-main.html` and `{root}/module-09/findbugs/build/reports/findbugs/main.html`

#### Module 10 : SQL Introduction
- To run or build this project from `console` for `*nix` systems: `./gradlew module-10:run` or `./gradlew module-10:build`
- To run or build this project from `console` for `windows` systems: `gradlew.bat module-10:run` or `gradlew.bat module-10:build`
- To run this project from `IDE`: execute `jmp.module10.Main` class

#### Module 11 : Build: Maven, Gradle
- All Commands should be executed from `{root}/module-11/gradle` folder for `gradle` and from `{root}/module-11/maven` folder for `maven`
- `tomcat` will be available for both projects by `http://localhost:8090/jmp-module-11`
- To build and run `gradle` project on `tomcat` from `console` for `*nix` systems: `./gradlew tomcatRunWar`
- To build and run `gradle` project on `tomcat` from `console` for `windows` systems: `gradlew.bat tomcatRunWar`
- To build and run `maven` project on `tomcat` from `console`: `mvn clean install` and `mvn tomcat:run`


#### Module 12 : Junit, Jmock
- To run tests or run project with tests from `console` for `*nix` systems: `./gradlew module-12:test` or `./gradlew module-12:run`
- To run tests or run project with tests from `console` for `windows` systems: `gradlew.bat module-12:test` or `gradlew.bat module-12:run`
- To run tests or run project from `IDE`: execute `jmp.module12.utils.UtilsTest` or `jmp.module12.Main`


#### Module 13 : Apache, Tomcat
- execute command `gradlew.bat module-13:initApache module-13:initTomcat` from `{root}` folder
- run `tomcat` `{root}/temporary/apache-tomcat-7.0.68/bin/startup.bat`
- run `apache` `{root}/temporary/Apache2/bin/Apache.exe`
- compare pages `http://localhost:8081/docs/config/` and `http://localhost:8082/docs/config/`
- execute command `gradlew.bat module-13:deployApache` from `{root}` folder to deploy static files on `apache`
- execute command `gradlew.bat module-13:build` from `{root}` folder to build `war`
- run `tomcat` web application manager `http://localhost:8082/manager/html` `user` : `tomcat`, `password` : `tomcat`
- deploy `module-13.war` from `{root}/module-13/build/libs` folder
- run application `http://localhost:8081/module-13/`


#### Module 14 : Continuous Integration Concepts (Jenkins)
- download `tomcat 7` (https://tomcat.apache.org/download-70.cgi)
- download `jenkins` (https://jenkins-ci.org)
- change `tomcat` http port in `{tomcat-folder}/conf/server.xml` `<Connector port="8082" protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="8443" />`
- add `tomcat` user in `{tomcat-folder}/conf/tomcat-users.xml` `<user username="tomcat" password="tomcat" roles="manager-script,manager-gui"/>`
- set `JAVA_OPTS` in `{tomcat-folder}/bin/startup.bat` `set JAVA_OPTS=-Xms512m -Xmx2048m -XX:PermSize=512m -XX:MaxPermSize=1024m`
- run `tomcat` `{tomcat-folder}/bin/startup.bat`
- go to `http://localhost:8082/manager/html` (`username` = `tomcat`, `password` = `tomcat`) and deploy `jenkins.war`
- go to `http://localhost:8082/jenkins`
- go to `http://localhost:8082/jenkins/pluginManager/available`
- install following plugins : `GitHub plugin` (1.17.1) and `Deploy to container Plugin` (1.10)
- go to `http://localhost:8082/jenkins/configure`
- configure following options
- add JDK `Name` = `local-jdk`, `JAVA_HOME` = `C:/Program Files/Java/jdk1.7.0_40`, `Install automatically` = `false`
- add Maven `Name` = `local-maven`, `MAVEN_HOME` = `D:/soft/mvn/apache-maven-3.3.1`, `Install automatically` = `false`, `Global MAVEN_OPTS` = `-Xmx1024m -XX:PermSize=512m -XX:MaxPermSize=512m`
- go to `http://localhost:8082/jenkins/`
- create new job
- set `Item name` = `spring-petclinic-deploy`
- select `Maven project`
- set `Source Code Management` = `git`
- set `Repository URL` = `https://github.com/vitali-yablonski/spring-petclinic.git`
- set `Build whenever a SNAPSHOT dependency is built` = `false`
- set `Poll SCM` = `H/5 * * * *`
- select `Add post-build action` as `Deploy war/ear to a container`
- set `WAR/EAR files` = `target/petclinic.war`
- set `Context path` = `petclinic`
- add Container
- set `Manager user name` = `tomcat`
- set `Manager password` = `tomcat`
- set `Tomcat URL` = `http://localhost:8082`
- `Apply` or `Save`
- go to application `http://localhost:8082/petclinic/`


#### Module 15 : Web-Services
- To build and run `gradle` project on `tomcat` from `console` for `*nix` systems: `./gradlew module-15:tomcatRunWar`
- To build and run `gradle` project on `tomcat` from `console` for `windows` systems: `gradlew.bat module-15:tomcatRunWar`
- Then go to `http://localhost:9090/jmp-module-15/sportgameservice`


#### Module 16 : JPA
- To run or build this project from `console` for `*nix` systems: `./gradlew module-16:run` or `./gradlew module-16:build`
- To run or build this project from `console` for `windows` systems: `gradlew.bat module-16:run` or `gradlew.bat module-16:build`
- To run this project from `IDE`: execute `jmp.module16.Main` class


#### Module 17 : Spring core
- To run or build this project from `console` for `*nix` systems: `./gradlew module-17:run` or `./gradlew module-17:build`
- To run or build this project from `console` for `windows` systems: `gradlew.bat module-17:run` or `gradlew.bat module-17:build`
- To run this project from `IDE`: execute `org.shop.ShopLauncher` class