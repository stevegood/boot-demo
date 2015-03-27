package org.stevegood.boot.demo.person

import org.springframework.data.mongodb.repository.MongoRepository

/**
 * Created by Steve on 3/26/2015.
 */
interface PersonRepository extends MongoRepository<Person, String> {
}
