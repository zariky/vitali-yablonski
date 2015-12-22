## JMP 2015-2016

#### Getting Started
- All [gradle](https://gradle.org/) commands should be executed from root folder
- To clean projects from `console` for `*nix` systems: `./gradlew clean`
- To clean projects from `console` for `windows` systems: `gradlew.bat clean`


#### Module 1 : Principle of Software Development (Micro Benchmark Application)
- To run or build this project from `console` for `*nix` systems: `./gradlew module-01:run` or `./gradlew module-01:build`
- To run or build this project from `console` for `windows` systems: `gradlew.bat module-01:run` or `gradlew.bat module-01:build`
- To run this project from `IDE`: execute `jmp.module01.Main` class with programm arguments `-b jmp.module01.tests.A -b  jmp.module01.tests.B`


#### Module 2 : UML
- Use Case, Component, Package, Sequence, State Machine, Class


#### Module 3 : Creational Patterns (Abstract Factory)
- To run or build this project from `console` for `*nix` systems: `./gradlew module-03:runFileMode` , `./gradlew module-03:runDbMode` or `./gradlew module-03:build`
- To run or build this project from `console` for `windows` systems: `gradlew.bat module-03:runFileMode` , `gradlew.bat module-03:runDbMode` or `gradlew.bat module-03:build`
- To run this project from `IDE`: execute `jmp.module03.Main` class with programm arguments `-source file` or `-source db`


#### Module 4 : Structural Patterns (Adapter)
- To run or build this project from `console` for `*nix` systems: `./gradlew module-04:run` or `./gradlew module-04:build`
- To run or build this project from `console` for `windows` systems: `gradlew.bat module-04:run` or `gradlew.bat module-04:build`
- To run this project from `IDE`: execute `jmp.module04.Main` class


#### Module 5 : Classloader
- To build of application into folder from `console` for `*nix` systems: `./gradlew :module-05/main-project:createApplication`
- To build of application into folder from `console` for `windows` systems: `gradlew.bat :module-05/main-project:createApplication`
- To build of application into folder from `IDE`: run `createApplication` task in `module-05/main-project` project
- After build, go to `{root}/temporary` folder and execute command `java -jar main-project-1.0.0-SNAPSHOT.jar`

