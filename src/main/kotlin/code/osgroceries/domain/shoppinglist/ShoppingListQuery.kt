package code.osgroceries.domain.shoppinglist

import code.osgroceries.domain.shoppinglist.services.GetShoppingListService
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ShoppingListQuery @Autowired constructor(
        private val getShoppingListService: GetShoppingListService
) : GraphQLQueryResolver {

    fun getShoppingList(): ShoppingList = getShoppingListService.getShoppingList()
}