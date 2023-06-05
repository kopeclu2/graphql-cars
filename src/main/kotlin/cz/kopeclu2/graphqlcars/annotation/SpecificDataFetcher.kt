package cz.kopeclu2.graphqlcars.annotation

import graphql.schema.DataFetcher
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class SpecificDataFetcher(
        val dataFetcherClazz: KClass<out DataFetcher<*>>
)