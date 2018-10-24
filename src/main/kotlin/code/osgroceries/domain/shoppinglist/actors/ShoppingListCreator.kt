package code.osgroceries.domain.shoppinglist.actors

import code.osgroceries.domain.shoppinglist.ShoppingList
import code.osgroceries.domain.shoppinglist.ShoppingListRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ShoppingListCreator @Autowired constructor(
        private val shoppingListRepository: ShoppingListRepository
) {

    fun createListItem(id: String, listItemIds: List<String>): ShoppingList {
        val shoppingList = ShoppingList(id, listItemIds)
        return shoppingListRepository.insert(shoppingList)
    }
}
