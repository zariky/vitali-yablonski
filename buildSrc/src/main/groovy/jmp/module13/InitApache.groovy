package jmp.module13

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

class InitApache extends DefaultTask {

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
        ant.copy( file: "${project.projectDir}/config-apache/mod-jk.conf", tofile: "${target.parent}/Apache2/conf/mod-jk/mod-jk.conf")
        ant.copy( file: "${project.projectDir}/config-apache/workers.properties", tofile: "${target.parent}/Apache2/conf/mod-jk/workers.properties")
        ant.copy( file: "${project.projectDir}/config-apache/mod_jk.so", tofile: "${target.parent}/Apache2/modules/mod_jk.so")

        File httpdConfFile = new File("${target.parent}/Apache2/conf/httpd.conf")
        String httpdConf = httpdConfFile.text
        httpdConf = httpdConf.replaceAll('D:/jmp-2015-2016/Apache2', "${target.parent}/Apache2".replaceAll('\\\\', '/'))
        httpdConf = httpdConf.replaceAll('Listen 8081', 'Listen ' + port)
        httpdConf = httpdConf << '\nInclude conf/mod-jk/mod-jk.conf'
        httpdConfFile.write(httpdConf)
    }

}