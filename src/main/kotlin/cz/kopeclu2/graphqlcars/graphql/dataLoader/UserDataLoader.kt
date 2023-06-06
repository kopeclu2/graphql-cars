package cz.kopeclu2.graphqlcars.graphql.dataLoader

import com.expediagroup.graphql.dataloader.KotlinDataLoader
import cz.kopeclu2.graphqlcars.UserEntity
import cz.kopeclu2.graphqlcars.repository.UserRepository
import kotlinx.coroutines.reactor.asFlux
import org.dataloader.DataLoader
import org.dataloader.DataLoaderFactory
import org.springframework.stereotype.Component
import java.util.*


@Component
class UserDataLoader(
        private val userRepository: UserRepository
) : KotlinDataLoader<UUID, UserEntity> {

    override val dataLoaderName: String = name

    override fun getDataLoader(): DataLoader<UUID, UserEntity> = DataLoaderFactory.newDataLoader { listOfIds ->
        userRepository.findAllById(listOfIds).asFlux().collectList().toFuture()
    }

    companion object {
        const val name = "UserDataLoader"
    }
}