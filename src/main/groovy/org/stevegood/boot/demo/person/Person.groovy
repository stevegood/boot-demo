package org.stevegood.boot.demo.person

import org.springframework.data.annotation.Id

/**
 * Created by Steve on 3/26/2015.
 */
class Person {

    @Id
    String id

    String firstName
    String lastName
}
