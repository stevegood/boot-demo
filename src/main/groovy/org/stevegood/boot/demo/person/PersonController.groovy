package org.stevegood.boot.demo.person

import groovy.util.logging.Log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * Created by Steve on 3/26/2015.
 */
@Log
@RestController
@RequestMapping('/person')
class PersonController {

    @Autowired
    PersonRepository personRepository

    @RequestMapping(method = RequestMethod.GET)
    List<Person> listPeople() {
        // TODO: Replace direct repository interaction with service
        personRepository.findAll()
    }

    @RequestMapping(value = '/{id}', method = RequestMethod.GET)
    Person getPerson(@PathVariable String id) {
        // TODO: Replace direct repository interaction with service
        personRepository.findOne(id)
    }

    @RequestMapping(method = RequestMethod.POST)
    Person createPerson(@RequestBody Person person) {
        // TODO: Replace direct repository interaction with service
        personRepository.save(person)
    }

    @RequestMapping(value = '/{id}', method = RequestMethod.PUT)
    Person updatePerson(@PathVariable String id, @RequestBody Person person) {
        // TODO: Replace direct repository interaction with service
        person.id = id
        personRepository.save(person)
    }

    @RequestMapping(value = '/{id}', method = RequestMethod.DELETE)
    def deletePerson(@PathVariable String id) {
        // TODO: Replace direct repository interaction with service
        personRepository.delete(id)
    }

}
