@Grapes([
	@GrabExclude('org.codehaus.groovy:groovy-all'),
	@Grab('org.hidetake:groovy-ssh:2.1.1'),
	@Grab('ch.qos.logback:logback-classic:1.1.2')
])
def ssh = org.hidetake.groovy.ssh.Ssh.newService()

