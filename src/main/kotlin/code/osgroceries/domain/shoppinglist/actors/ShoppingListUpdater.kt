package code.osgroceries.domain.shoppinglist.actors

import code.osgroceries.domain.listitem.ListItem
import code.osgroceries.domain.listitem.exceptions.ListItemNotFoundException
import code.osgroceries.domain.shoppinglist.ShoppingList
import code.osgroceries.domain.shoppinglist.ShoppingListRepository
import code.osgroceries.domain.shoppinglist.exceptions.ShoppingListNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ShoppingListUpdater @Autowired constructor(
        private val shoppingListRepository: ShoppingListRepository
) {

    fun updateShoppingList(shoppingList: ShoppingList): ShoppingList {
        if (!shoppingListRepository.existsById(shoppingList.id))
            throw ShoppingListNotFoundException("ShoppingList with id ${shoppingList.id} not found.")

        return shoppingListRepository.save(shoppingList)
    }
}