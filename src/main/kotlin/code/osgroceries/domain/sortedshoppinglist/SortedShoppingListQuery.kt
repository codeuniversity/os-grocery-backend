package code.osgroceries.domain.sortedshoppinglist

import code.osgroceries.domain.sortedshoppinglist.services.GetSortedShoppingListService
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SortedShoppingListQuery @Autowired constructor(
        private val getSortedShoppingListService: GetSortedShoppingListService
) : GraphQLQueryResolver {

    fun getSortedShoppingList(): SortedShoppingList = getSortedShoppingListService.getSortedShoppingList()
}