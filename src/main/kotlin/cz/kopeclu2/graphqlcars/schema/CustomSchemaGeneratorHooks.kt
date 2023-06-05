package cz.kopeclu2.graphqlcars.schema

import com.expediagroup.graphql.generator.hooks.SchemaGeneratorHooks
import graphql.scalars.ExtendedScalars
import graphql.schema.GraphQLType
import org.springframework.context.annotation.Configuration
import java.util.UUID
import kotlin.reflect.KClass
import kotlin.reflect.KType

@Configuration
class CustomSchemaGeneratorHooks : SchemaGeneratorHooks {

    override fun willGenerateGraphQLType(type: KType): GraphQLType? = when (type.classifier as? KClass<*>) {
        UUID::class -> ExtendedScalars.UUID
        else -> null
    }
}
