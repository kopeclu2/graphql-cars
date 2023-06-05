package cz.kopeclu2.graphqlcars.schema

import com.expediagroup.graphql.generator.execution.SimpleKotlinDataFetcherFactoryProvider
import cz.kopeclu2.graphqlcars.annotation.SpecificDataFetcher
import graphql.schema.DataFetcher
import graphql.schema.DataFetcherFactory
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Component
import kotlin.reflect.KClass
import kotlin.reflect.KProperty
import kotlin.reflect.jvm.javaField

@Component
class DataFetcherFactoryProvider(
        private val applicationContext: ApplicationContext
) : SimpleKotlinDataFetcherFactoryProvider() {

    override fun propertyDataFetcherFactory(kClass: KClass<*>, kProperty: KProperty<*>): DataFetcherFactory<Any?> {
        if (kProperty.isAnnotated(SpecificDataFetcher::class)) {
            val dataFetcherAnnotation = kProperty.getAnnotation(SpecificDataFetcher::class)
            val kClassDataFetcher = dataFetcherAnnotation?.dataFetcherClazz
                    ?: return super.propertyDataFetcherFactory(kClass, kProperty)
            val dataFetcher = applicationContext.getBean(kClassDataFetcher.java)
            return DataFetcherFactory<Any?> {
                dataFetcher as DataFetcher<Any?>
            }
        }
        return super.propertyDataFetcherFactory(kClass, kProperty)
    }

    private fun KProperty<*>.isAnnotated(annotation: KClass<out Annotation>): Boolean {
        return this.javaField?.isAnnotationPresent(annotation.java) ?: false
    }

    private fun <T : Annotation> KProperty<*>.getAnnotation(annotation: KClass<T>): T? {
        return this.javaField?.getAnnotation(annotation.java)
    }

}

