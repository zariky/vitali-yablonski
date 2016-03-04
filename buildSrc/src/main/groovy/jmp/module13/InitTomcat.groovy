package jmp.module13

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

class InitTomcat  extends DefaultTask {

    @Input
    String source

    @Input
    String port

    @OutputFile
    File target

    @TaskAction
    void init() {
        def ant = new AntBuilder()
        ant.get(src: source, dest: target)
        ant.unzip(src: target,  dest: target.parent)
        ant.copy( file: "${project.projectDir}/config-tomcat/server.xml", tofile: "${target.parent}/apache-tomcat-7.0.68/conf/server.xml")
        ant.copy( file: "${project.projectDir}/config-tomcat/tomcat-users.xml", tofile: "${target.parent}/apache-tomcat-7.0.68/conf/tomcat-users.xml")

        File tomcatConfFile = new File("${target.parent}/apache-tomcat-7.0.68/conf/server.xml")
        tomcatConfFile.write(tomcatConfFile.text.replaceAll('8080', port))
    }

}