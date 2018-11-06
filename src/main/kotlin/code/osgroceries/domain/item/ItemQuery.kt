package code.osgroceries.domain.item

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Service

@Service
class ItemQuery : GraphQLQueryResolver {

    fun getItems(): List<Item> = TODO()
}