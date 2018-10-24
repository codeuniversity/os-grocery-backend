package code.osgroceries.domain.shoppinglist

import code.osgroceries.domain.listitem.services.ListItemGetAllService
import com.coxautodev.graphql.tools.GraphQLResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ShoppingListResolver @Autowired constructor(
        private val listItemGetAllService: ListItemGetAllService
) : GraphQLResolver<ShoppingList> {

    fun listItems(shoppingList: ShoppingList) =
            listItemGetAllService.getAllInShoppingListWithId(shoppingList.id)
}
