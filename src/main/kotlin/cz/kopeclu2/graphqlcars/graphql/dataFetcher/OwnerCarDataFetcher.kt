package cz.kopeclu2.graphqlcars.graphql.dataFetcher

import cz.kopeclu2.graphqlcars.UserEntity
import cz.kopeclu2.graphqlcars.graphql.dataLoader.UserDataLoader
import cz.kopeclu2.graphqlcars.graphql.response.CarResponse
import cz.kopeclu2.graphqlcars.graphql.response.UserResponse
import graphql.schema.DataFetcher
import graphql.schema.DataFetchingEnvironment
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.*
import java.util.concurrent.CompletableFuture

@Component
class OwnerCarDataFetcher : DataFetcher<CompletableFuture<UserResponse>> {

    private val log = LoggerFactory.getLogger(OwnerCarDataFetcher::class.java)
    override fun get(environment: DataFetchingEnvironment): CompletableFuture<UserResponse> {
        val ownerId = environment.getSource<CarResponse>().ownerId
        log.info("OwnerCarDataFetcher was called with value of owner: '$ownerId'")
        return environment.getDataLoader<UUID, UserEntity>(UserDataLoader.name)
                .load(ownerId)
                .thenApply { userEntity ->
                    UserResponse(
                            userEntity.id,
                            userEntity.name,
                            userEntity.email
                    )
                }
    }
}