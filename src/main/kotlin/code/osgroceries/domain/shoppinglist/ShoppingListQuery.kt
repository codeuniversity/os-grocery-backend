package code.osgroceries.domain.shoppinglist

import code.osgroceries.domain.shoppinglist.services.ShoppingListGetAllService
import com.coxautodev.graphql.tools.GraphQLResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ShoppingListQuery @Autowired constructor(
        private val shoppingListGetAllService: ShoppingListGetAllService
) : GraphQLResolver<ShoppingList> {

    fun getAllShoppingLists() = shoppingListGetAllService.getAll()
}
