package org.stevegood.boot.demo.hello

import org.stevegood.boot.demo.person.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.stevegood.boot.demo.person.PersonService

/**
 * Created by Steve on 3/26/2015.
 */
@RestController
@RequestMapping('/hello')
class HelloController {

    @Autowired
    PersonService personService

    @RequestMapping(value = '/{personId}', method = RequestMethod.GET)
    Hello sayHelloToPerson(@PathVariable String personId) {
        Person person = personService.findById(personId)
        new Hello(person: person, greeting: "Hello, ${person.firstName} ${person.lastName}")
    }

}
