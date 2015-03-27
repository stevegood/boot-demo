package org.stevegood.boot.demo.hello

import org.stevegood.boot.demo.person.Person
import org.springframework.web.client.RestTemplate
import org.stevegood.boot.demo.ContextSpecification
import spock.lang.Unroll

/**
 * Created by Steve on 3/26/2015.
 */
class HelloControllerSpec extends ContextSpecification {

    String personUrl = 'http://localhost:8080/person'
    String helloUrl = 'http://localhost:8080/hello'

    @Unroll
    def "test the hello service [ Saying hello to #firstName #lastName ]"() {
        when:
        def response = new RestTemplate().postForEntity(personUrl, [firstName: firstName, lastName: lastName], Person)
        Person person = response.body

        then:
        person.firstName == firstName
        person.lastName == lastName

        when:
        response = new RestTemplate().getForEntity("$helloUrl/$person.id", Hello)
        Hello hello = response.body

        then:
        println '-----------------------------------------------'
        println "Should be saying hello to $firstName $lastName"
        println "Actually saying, '$hello.greeting'"
        println '-----------------------------------------------'

        hello.person.firstName == firstName
        hello.person.lastName == lastName
        assert hello.greeting.contains(firstName)
        assert hello.greeting.contains(lastName)

        when:
        new RestTemplate().delete("$personUrl/${person.id}")
        response = new RestTemplate().getForEntity("$personUrl/${person.id}", Person)

        then:
        response.body == null

        where:
        firstName   |   lastName
        'Steve'     |   'Good'
        'MC'        |   'Hammer'
        'Homer'     |   'Simpson'
    }

}
