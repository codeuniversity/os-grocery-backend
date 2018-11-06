package code.osgroceries.domain.supermarket

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Service

@Service
class SupermarketQuery : GraphQLQueryResolver {

    fun getAllSupermarkets(): List<Supermarket> = TODO()
}