package grailsredis

class RedisDemoController {

    def redisService

    def checking() {
        String key = "Tenant:list"
        Integer oneMinute = 60//second
        println "checking"
        List<Tenent> tenents = redisService.memoizeDomainList(Tenent, key, oneMinute) {
            println "adding New key"
            List<Tenent> tenents = Tenent.list()
            return tenents
        }
    }

    def testingSavedList(){

    }


}
