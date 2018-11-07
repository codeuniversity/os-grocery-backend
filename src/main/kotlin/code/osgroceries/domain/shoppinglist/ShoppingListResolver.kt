package code.osgroceries.domain.shoppinglist

import code.osgroceries.domain.item.Item
import code.osgroceries.domain.item.services.GetItemService
import com.coxautodev.graphql.tools.GraphQLResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ShoppingListResolver @Autowired constructor(
        private val getItemService: GetItemService
) : GraphQLResolver<ShoppingList> {

    fun items(shoppingList: ShoppingList): List<Item> = shoppingList.listItems.map { getItemService.getItemById(it.itemId) }
}
