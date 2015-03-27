package org.stevegood.boot.demo.person

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by Steve on 3/26/2015.
 */
@Service
class PersonService {

    @Autowired
    PersonRepository personRepository

    Person findById(String id) {
        personRepository.findOne(id)
    }

}
