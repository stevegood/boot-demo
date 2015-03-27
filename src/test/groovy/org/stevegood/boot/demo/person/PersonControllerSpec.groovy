package org.stevegood.boot.demo.person

import org.stevegood.boot.demo.ContextSpecification
import org.springframework.web.client.RestTemplate
import spock.lang.Unroll

/**
 * Created by Steve on 3/26/2015.
 */

class PersonControllerSpec extends ContextSpecification {

    String personUrl = 'http://localhost:8080/person'

    @Unroll
    def "tests person crud [ #firstName #lastName ]"() {
        when:
        def response = new RestTemplate().postForEntity(personUrl, [firstName: firstName, lastName: lastName], Person)
        Person person = response.body

        then:
        person.firstName == firstName
        person.lastName == lastName

        when:
        response = new RestTemplate().getForEntity("$personUrl/${person.id}", Person)
        Person person2 = response.body

        then:
        person2.id == person.id
        person2.firstName == person.firstName
        person2.lastName == person.lastName

        when:
        person2.firstName = "${firstName}ZZZ"
        new RestTemplate().put("$personUrl/${person.id}", person2)
        response = new RestTemplate().getForEntity("$personUrl/${person.id}", Person)
        person2 = response.body

        then:
        person2.id == person.id
        person2.firstName == "${firstName}ZZZ"
        person2.lastName == person.lastName

        when:
        new RestTemplate().delete("$personUrl/${person.id}")
        response = new RestTemplate().getForEntity("$personUrl/${person.id}", Person)

        then:
        response.body == null

        where:
        firstName   |   lastName
        'Steve'     |   'Good'
        'Homer'     |   'Simpson'
        'MC'        |   'Hammer'
    }

}
