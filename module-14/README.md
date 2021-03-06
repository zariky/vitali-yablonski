#### Continuous Integration Concepts (Jenkins)
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