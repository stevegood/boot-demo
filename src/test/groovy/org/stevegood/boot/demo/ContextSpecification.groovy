package org.stevegood.boot.demo

import org.springframework.boot.SpringApplication
import org.springframework.context.ConfigurableApplicationContext
import spock.lang.Shared
import spock.lang.Specification

import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit

/**
 * Created by Steve on 3/26/2015.
 */
class ContextSpecification extends Specification {

    @Shared
    ConfigurableApplicationContext context

    void setupSpec() {
        Future future = Executors
                .newSingleThreadExecutor().submit(
                new Callable() {
                    @Override
                    public ConfigurableApplicationContext call() throws Exception {
                        return (ConfigurableApplicationContext) SpringApplication
                                .run(MicroserviceApplication.class)
                    }
                })
        context = future.get(60, TimeUnit.SECONDS)
    }

    void cleanupSpec() {
        if (context != null) {
            context.close()
        }
    }

}
