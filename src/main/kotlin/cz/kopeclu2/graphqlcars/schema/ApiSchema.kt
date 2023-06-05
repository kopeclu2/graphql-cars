package cz.kopeclu2.graphqlcars.schema

import com.expediagroup.graphql.generator.federation.directives.ContactDirective
import com.expediagroup.graphql.server.Schema
import org.springframework.stereotype.Component

@ContactDirective(
        name = "Kopeclu2",
        url = "website"
)
@Component
class ApiSchema : Schema
