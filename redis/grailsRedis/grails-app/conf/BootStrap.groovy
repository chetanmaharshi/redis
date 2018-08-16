import grailsredis.Attendee
import grailsredis.Contact
import grailsredis.Tenent
import groovy.json.JsonBuilder
import groovy.json.JsonSlurper

class BootStrap {

    //http://plugins.grails.org/plugin/ctoestreich/redis
    //https://grails.org/plugin/redis?skipRedirect=true
    //https://www.oodlestechnologies.com/blogs/Using-redis-in-your-grails-application.
    //https://www.tutorialspoint.com/redis/redis_java.htm
    //https://github.com/rgl/redis/downloads
    def redisService
    def init = { servletContext ->

        if(!Tenent.findByName("Arun")){
            Contact contact = new Contact(number: "9718124871").save()
            Contact contact1 = new Contact(number: "8130457896").save()

            Tenent tenent1 = new Tenent(name:"Arun",description: "Arun tenent desc");
            tenent1.contacts = [contact,contact1]
            tenent1.save(flush: true)
        }

        if(!Tenent.findByName("Chetan")){
            Contact contact = new Contact(number: "9999999999").save()
            Contact contact1 = new Contact(number: "66666666666").save()

            Tenent tenent1 = new Tenent(name:"Chetan",description: "Chetan tenent desc");
            tenent1.addToContacts(contact)
            tenent1.addToContacts(contact1)
            tenent1.save(flush: true)
        }

        if(!Tenent.findByName("Deepak")){
            Contact contact = new Contact(number: "3333333333").save()
            Contact contact1 = new Contact(number: "4444444444").save()

            Tenent tenent1 = new Tenent(name:"Deepak",description: "Deepak tenent desc");
            tenent1.addToContacts(contact)
            tenent1.addToContacts(contact1)
            tenent1.save(flush: true)
        }

        if(!Attendee.findByAttendeeName("Chetan Attendee")){
            Contact contact = new Contact(number: "22222222222").save()
            Attendee attendee = new Attendee(attendeeName: "Chetan Attendee",contact:contact).save()
        }
        if(!Attendee.findByAttendeeName("Arun Attendee")){
            Contact contact = new Contact(number: "8888888888").save()
            Attendee attendee = new Attendee(attendeeName: "Arun Attendee",contact:contact).save()
        }
        if(!Attendee.findByAttendeeName("Deepak Attendee")){
            Contact contact = new Contact(number: "55555555555").save()
            Attendee attendee = new Attendee(attendeeName: "Deepak Attendee",contact:contact).save()
        }

    }
    def destroy = {
    }
}
