package grailsredis

class Tenent {

    String name
    String description

    static hasMany = [contacts:Contact]

    static constraints = {
        contacts nullable: true
    }
}
