package code.osgroceries.domain.listitem.services

import code.osgroceries.domain.listitem.ListItem
import code.osgroceries.domain.shoppinglist.services.GetShoppingListService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GetUnfetchedAndFetchedListItemsService @Autowired constructor(
        private val getShoppingListService: GetShoppingListService
) {

    fun getUnfetchedAndFetchedListItems(): List<List<ListItem>> {
        val listItems = getShoppingListService.getShoppingList().listItems

        val unfetchedListItems = mutableListOf<ListItem>()
        val fetchedListItems = mutableListOf<ListItem>()

        listItems.forEach {
            if (it.fetched) {
                fetchedListItems.add(it)
            } else {
                unfetchedListItems.add(it)
            }
        }

        return listOf(unfetchedListItems, fetchedListItems)
    }
}
