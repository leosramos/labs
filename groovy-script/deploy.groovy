@Grab('org.hidetake:groovy-ssh:2.1.1')
@GrabExclude('org.codehaus.groovy:groovy-all')
@Grab('ch.qos.logback:logback-classic:1.1.2')
def ssh = org.hidetake.groovy.ssh.Ssh.newService()
println "Test"