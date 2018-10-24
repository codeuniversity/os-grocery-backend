package code.osgroceries.domain.shoppinglist

import code.osgroceries.domain.shoppinglist.services.ShoppingListCreateService
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ShoppingListMutation @Autowired constructor(
        private val shoppingListCreateService: ShoppingListCreateService
) : GraphQLMutationResolver {

    fun createShoppingList() =
            shoppingListCreateService.create()
}
