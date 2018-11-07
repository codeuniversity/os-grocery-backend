package code.osgroceries.domain.sortedshoppinglist.services

import code.osgroceries.domain.sortedlistitem.services.GetUnfetchedAndFetchedItemsService
import code.osgroceries.domain.sortedshoppinglist.SortedShoppingList
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GetSortedShoppingListService @Autowired constructor(
        private val getUnfetchedAndFetchedItemsService: GetUnfetchedAndFetchedItemsService
){

    fun getSortedShoppingList(): SortedShoppingList {
        val (unfetchedItems, fetchedItems) = getUnfetchedAndFetchedItemsService.getUnfetchedAndFetchedItems()
        return SortedShoppingList(unfetchedItems, fetchedItems)
    }
}