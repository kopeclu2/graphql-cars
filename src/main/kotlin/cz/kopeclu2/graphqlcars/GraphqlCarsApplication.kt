package cz.kopeclu2.graphqlcars

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux

@EnableWebFlux
@SpringBootApplication
class GraphqlCarsApplication

fun main(args: Array<String>) {
    runApplication<GraphqlCarsApplication>(*args)
}
