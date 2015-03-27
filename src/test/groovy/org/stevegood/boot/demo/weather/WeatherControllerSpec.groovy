package org.stevegood.boot.demo.weather

import org.springframework.web.client.RestTemplate
import org.stevegood.boot.demo.ContextSpecification
import spock.lang.Ignore
import spock.lang.Unroll

/**
 * Created by Steve on 3/26/2015.
 */
class WeatherControllerSpec extends ContextSpecification {

    @Ignore
    @Unroll
    def "Testing the weather controller for #zipcode ( #city )"() {
        when:
        def response = new RestTemplate().getForEntity("http://localhost:8080/weather/$zipcode", Object)
        println response.body

        then:
        response.body != null
        response.body.name == city

        where:
        city                    |   zipcode
        'North Richland Hills'  |   76182
        'Dana Point'            |   92629
    }

}
