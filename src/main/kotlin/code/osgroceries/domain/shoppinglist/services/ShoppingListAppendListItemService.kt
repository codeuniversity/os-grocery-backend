package code.osgroceries.domain.shoppinglist.services

import code.osgroceries.domain.listitem.ListItem
import code.osgroceries.domain.listitem.actors.ListItemFinder
import code.osgroceries.domain.shoppinglist.ShoppingList
import code.osgroceries.domain.shoppinglist.actors.ShoppingListFinder
import code.osgroceries.domain.shoppinglist.actors.ShoppingListUpdater
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ShoppingListAppendListItemService @Autowired constructor(
        private val shoppingListUpdater: ShoppingListUpdater,
        private val shoppingListFinder: ShoppingListFinder
) {

    fun appendListItemToShoppingList(shoppingListId: String, listItem: ListItem): ShoppingList {
        val originalShoppingList = shoppingListFinder.findById(shoppingListId)

        val listItemIds = getListItemIdsFromListAndNewId(originalShoppingList.listItemIds, listItem)

        val shoppingList = ShoppingList(shoppingListId, listItemIds)
        return shoppingListUpdater.updateShoppingList(shoppingList)
    }

    private fun getListItemIdsFromListAndNewId(originalListItemIds: List<String>, listItem: ListItem): MutableList<String> {
        val listItemIds = mutableListOf<String>()
        listItemIds.addAll(originalListItemIds)
        listItemIds.add(listItem.id)
        return listItemIds
    }
}