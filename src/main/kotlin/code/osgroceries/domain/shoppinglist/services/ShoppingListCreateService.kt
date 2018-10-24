package code.osgroceries.domain.shoppinglist.services

import code.osgroceries.domain.shoppinglist.ShoppingList
import code.osgroceries.domain.shoppinglist.actors.ShoppingListCreator
import code.osgroceries.util.generateId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ShoppingListCreateService @Autowired constructor(
        private val shoppingListCreator: ShoppingListCreator
) {

    fun create(): ShoppingList {
        val id = generateId()
        val listItemIds = listOf<String>()

        return shoppingListCreator.createListItem(id, listItemIds)
    }
}
