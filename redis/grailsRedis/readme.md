1. first install redis on window.

Note for window you will not able to find any latest version of redis
you can download and install it from here
https://github.com/rgl/redis/downloads

2. After installation. 
Go to this location C:\Program Files\Redis

and click on redis-server.exe file to start the redis

3. If it is already started then you dont need to do any thing

4. If you want to explicitly start the redis then first stop the redis from 
window task manager -> services -> search for redis and then click on stop link

5. after that you can follow 2nd step

6. In buildConfig.groovy file you need to install below plugins

runtime "org.grails.plugins:redis:1.6.7"

7. then In config.groovy file paste below line
grails {
    redis {
        poolConfig {
            // jedis pool specific tweaks here, see jedis docs & src
            // ex: testWhileIdle = true
        }
        timeout = 2000 //default in milliseconds
       // password = "somepassword" //defaults to no password
        useSSL = false //or true to use SSL

        // requires either host & port combo, or a sentinels and masterName combo

        // use a single redis server (use only if nore using sentinel cluster)
        port = 6379
        host = "localhost"
        database = 5 // set default database to 5

        // use redis-sentinel cluster as opposed to a single redis server (use only if not use host/port)
        //sentinels = [ "host1:6379", "host2:6379", "host3:6379" ] // list of sentinel instance host/ports
        masterName = "MasterCuster" // the name of a master the sentinel cluster is configured to monitor
    }
}

8. then you can follow step in below link

https://grails.org/plugin/redis?skipRedirect=true

some sample code

def redisService

String key = "Tenant:list"
Integer oneMinute = 60//second
println "checking"
List<Tenent> tenents = redisService.memoizeDomainList(Tenent, key, oneMinute) {
    println "adding New key"
    List<Tenent> tenents = Tenent.list()
    return tenents
}

String key = "Arun"
Integer fiveMinute = 300
println "checking"
Tenent tenent = redisService.memoizeDomainObject(Tenent, key, fiveMinute) {
    println "adding New key"
    Tenent tenent = Tenent.findByName("Arun")
    return tenent
}