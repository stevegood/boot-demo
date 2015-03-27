package org.stevegood.boot.demo

import groovy.util.logging.Log
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@Log
@SpringBootApplication
class MicroserviceApplication implements CommandLineRunner {

    static void main(String[] args) {
        SpringApplication.run MicroserviceApplication, args
    }

    void run(String... args) {
        log.info 'Application bootstrapping...'
        log.info 'Bootstrapping complete!'
    }
}
