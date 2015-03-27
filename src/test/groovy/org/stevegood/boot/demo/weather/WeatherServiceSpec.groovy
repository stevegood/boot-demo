package org.stevegood.boot.demo.weather

import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by Steve on 3/26/2015.
 */
class WeatherServiceSpec extends Specification {

    WeatherService weatherService

    def setup() {
        weatherService = new WeatherService()
    }

    @Ignore
    @Unroll
    def "test the weather service for city #city"() {
        when:
        def weather = weatherService.getForCity(city)

        then:
        weather.name == city

        where:
        city                        |   country
        'North Richland Hills'      |   'US'
        'Dana Point'                |   'US'

    }

}
