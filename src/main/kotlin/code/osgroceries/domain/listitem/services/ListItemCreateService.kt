package code.osgroceries.domain.listitem.services

import code.osgroceries.domain.listitem.ListItem
import code.osgroceries.domain.listitem.actors.ListItemCreator
import code.osgroceries.domain.shoppinglist.services.ShoppingListAppendListItemService
import code.osgroceries.util.generateId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ListItemCreateService @Autowired constructor(
        private val listItemCreator: ListItemCreator,
        private val shoppingListAppendListItemService: ShoppingListAppendListItemService
) {

    fun createListItem(name: String, shoppingListId: String): ListItem {
        val id = generateId()

        val listItem = listItemCreator.createListItem(id, name, shoppingListId)

        shoppingListAppendListItemService.appendListItemToShoppingList(shoppingListId, listItem)

        return listItem
    }
}
