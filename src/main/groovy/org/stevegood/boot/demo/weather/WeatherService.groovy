package org.stevegood.boot.demo.weather

import groovyx.net.http.RESTClient
import org.springframework.stereotype.Service

/**
 * Created by Steve on 3/26/2015.
 */
@Service
class WeatherService {

    private static final String base = 'http://api.openweathermap.org'

    def getForCity(String city) {
        def http = new RESTClient(base)
        def response = http.get(
            path: '/data/2.5/weather',
            query: [
                q: "$city,US"
            ]
        )

        response.responseData
    }

}
