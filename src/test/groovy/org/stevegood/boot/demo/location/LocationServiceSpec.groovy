package org.stevegood.boot.demo.location

import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by Steve on 3/26/2015.
 */
class LocationServiceSpec extends Specification {

    LocationService service

    def setup() {
        service = new LocationService()
    }

    @Ignore
    @Unroll
    def "Tests the location service for zipcode #zipcode [ #city, #state ]"() {
        when:
        def cities = service.getByZipcode(zipcode)

        then:
        cities.size() > 0
        cities[0].city.toLowerCase() == city
        cities[0].state_abbreviation.toLowerCase() == state

        where:
        zipcode     |   state   |   city
        76182       |   'tx'    |   'north richland hills'
        92629       |   'ca'    |   'dana point'
    }

}
