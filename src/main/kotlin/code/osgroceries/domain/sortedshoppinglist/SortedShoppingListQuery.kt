package code.osgroceries.domain.sortedshoppinglist

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Service

@Service
class SortedShoppingListQuery : GraphQLQueryResolver {

    fun getSortedShoppingList(): SortedShoppingList = TODO()
}