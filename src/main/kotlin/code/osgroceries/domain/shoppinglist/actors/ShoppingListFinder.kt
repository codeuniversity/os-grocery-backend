package code.osgroceries.domain.shoppinglist.actors

import code.osgroceries.domain.shoppinglist.ShoppingList
import code.osgroceries.domain.shoppinglist.ShoppingListRepository
import code.osgroceries.domain.shoppinglist.exceptions.ShoppingListNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ShoppingListFinder @Autowired constructor(
        private val shoppingListRepository: ShoppingListRepository
) {

    fun findAll(): List<ShoppingList> {
        val allShoppingLists = shoppingListRepository.findAll()
        return allShoppingLists.filter { it != null }
    }

    fun findById(id: String): ShoppingList {
        val optionalShoppingList = shoppingListRepository.findById(id)

        if (!optionalShoppingList.isPresent)
            throw ShoppingListNotFoundException("ShoppingList with id $id not found.")

        return optionalShoppingList.get()
    }
}
