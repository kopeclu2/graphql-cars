package cz.kopeclu2.graphqlcars.graphql.query

import com.expediagroup.graphql.server.operations.Query
import cz.kopeclu2.graphqlcars.graphql.response.CarResponse
import org.springframework.context.annotation.Description
import org.springframework.stereotype.Component
import java.util.*

@Component
class CarsQuery : Query {

    @Description("Get list of cars")
    fun getAllCars(): List<CarResponse> = listOf(
            CarResponse(
                    UUID.fromString("d2d332b0-f922-43d4-af0c-efa976e9d4ae"),
                    make = "Audi",
                    model = "RS6",
                    year = 2004,
                    ownerId = UUID.fromString("d2d332b0-f922-43d4-af0c-efa976e9d4ee")
            ),
            CarResponse(
                    UUID.fromString("d2d332b0-f922-43d4-af0c-efa976e9d4be"),
                    make = "Skoda",
                    model = "Fabia II",
                    year = 2005,
                    ownerId = UUID.fromString("d2d332b0-f922-43d4-af0c-efa976e9d4ea")
            ),
    )
}