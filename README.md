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