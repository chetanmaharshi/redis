package grailsredis

class Contact {

    String number

    static constraints = {
        number nullable: false
    }
}
