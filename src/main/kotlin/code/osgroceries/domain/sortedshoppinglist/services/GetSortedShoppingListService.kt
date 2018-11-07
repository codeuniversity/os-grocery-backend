package code.osgroceries.domain.sortedshoppinglist.services

import code.osgroceries.domain.sortedlistitem.services.GetUnfetchedAndFetchedSortedListItemsService
import code.osgroceries.domain.sortedshoppinglist.SortedShoppingList
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GetSortedShoppingListService @Autowired constructor(
        private val getUnfetchedAndFetchedSortedListItemsService: GetUnfetchedAndFetchedSortedListItemsService
){

    fun getSortedShoppingList(): SortedShoppingList {
        val (unfetchedItems, fetchedItems) = getUnfetchedAndFetchedSortedListItemsService.getUnfetchedAndFetchedSortedListItems()
        return SortedShoppingList(unfetchedItems, fetchedItems)
    }
}