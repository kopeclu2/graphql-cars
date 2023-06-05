package cz.kopeclu2.graphqlcars.graphql.response

import com.expediagroup.graphql.generator.annotations.GraphQLIgnore
import cz.kopeclu2.graphqlcars.annotation.SpecificDataFetcher
import cz.kopeclu2.graphqlcars.graphql.dataFetcher.OwnerCarDataFetcher
import java.util.*


data class CarResponse(
        val id: UUID,
        val make: String,
        val model: String,
        val year: Int,
        @GraphQLIgnore val ownerId: UUID
) {

    @field:SpecificDataFetcher(OwnerCarDataFetcher::class)
    lateinit var owner: UserResponse
}
