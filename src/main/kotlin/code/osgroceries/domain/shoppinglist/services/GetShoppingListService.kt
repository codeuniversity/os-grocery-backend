package code.osgroceries.domain.shoppinglist.services

import code.osgroceries.domain.listitem.ListItem
import code.osgroceries.domain.listitem.services.GetListItemsService
import code.osgroceries.domain.shoppinglist.ShoppingList
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GetShoppingListService @Autowired constructor(
        private val getListItemsService: GetListItemsService
) {

    fun getShoppingList(): ShoppingList {
        val listItems: List<ListItem> = getListItemsService.getListItems()
        return ShoppingList(listItems)
    }
}