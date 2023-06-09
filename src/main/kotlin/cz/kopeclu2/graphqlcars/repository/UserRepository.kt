package cz.kopeclu2.graphqlcars.repository

import cz.kopeclu2.graphqlcars.UserEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOf
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserRepository {
    private val log = LoggerFactory.getLogger(UserRepository::class.java)

    val users: Flow<UserEntity> = flowOf(
            UserEntity(
                    UUID.fromString("d2d332b0-f922-43d4-af0c-efa976e9d4ea"),
                    "Kopecky Lukas",
                    "test@test.cz"
            ),
            UserEntity(
                    UUID.fromString("d2d332b0-f922-43d4-af0c-efa976e9d4ee"),
                    "Bohdan Tomas",
                    "tomas@bohdan.cz"
            ),
            UserEntity(
                    UUID.fromString("d2d332b0-f922-43d4-af0c-efa976e9d4eb"),
                    "Pavel Ales",
                    "ales@pavel.cz"
            )
    )

    fun findAllById(ids: List<UUID>): Flow<UserEntity> {
        log.info("Database SQL was called with ids: $ids")
        return users.filter { user -> ids.contains(user.id) }
    }
}