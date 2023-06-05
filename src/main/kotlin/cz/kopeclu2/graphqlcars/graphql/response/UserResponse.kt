package cz.kopeclu2.graphqlcars.graphql.response

import java.util.UUID

data class UserResponse(
        val id: UUID,
        val name: String,
        val email: String
)