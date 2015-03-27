package org.stevegood.boot.demo.weather

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by Steve on 3/26/2015.
 */
@RestController
@RequestMapping('/weather')
class WeatherController {

//    @Autowired
//    LocationService locationService
//
//    @Autowired
//    WeatherService weatherService
//
//    @RequestMapping(value = '/{zipcode}', method = RequestMethod.GET)
//    def getWeatherByZipcode(@PathVariable String zipcode) {
//        def cities = locationService.getByZipcode(zipcode)
//        weatherService.getForCity(cities[0].city)
//    }

}
