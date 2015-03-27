package org.stevegood.boot.demo.location

import groovyx.net.http.RESTClient
import org.springframework.stereotype.Service

/**
 * Created by Steve on 3/26/2015.
 */
@Service
class LocationService {

    private static final String auth_id = 'dcdc0fc3-25ac-4f77-a320-2dddc7cdec56'
    private static final String auth_token = 'D34cvq7SIxTnJnCCvIC7'

    def getByZipcode(def zipcode) {
        def http = new RESTClient('https://api.smartystreets.com')
        def response = http.get(
            path: '/zipcode',
            query: [
                zipcode: zipcode,
                'auth-id': auth_id,
                'auth-token': auth_token
            ]
        )
        response?.responseData?.getAt(0)?.city_states
    }

}
