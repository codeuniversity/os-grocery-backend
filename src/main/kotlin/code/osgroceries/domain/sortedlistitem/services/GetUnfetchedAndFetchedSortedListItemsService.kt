package code.osgroceries.domain.sortedlistitem.services

import code.osgroceries.domain.listitem.services.GetUnfetchedAndFetchedListItemsService
import code.osgroceries.domain.sortedlistitem.SortedListItem
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GetUnfetchedAndFetchedSortedListItemsService @Autowired constructor(
        private val getUnfetchedAndFetchedListItemsService: GetUnfetchedAndFetchedListItemsService,
        private val listItemToSortedListItemConverterService: ListItemToSortedListItemConverterService
) {

    fun getUnfetchedAndFetchedSortedListItems(supermarketId: String): List<List<SortedListItem>> {
        val (unfetchedListItems, fetchedListItems) = getUnfetchedAndFetchedListItemsService.getUnfetchedAndFetchedListItems()

        val unfetchedSortedListItems = unfetchedListItems.map {
                listItemToSortedListItemConverterService.convertListItemToSortedListItem(it, supermarketId)
        }

        val fetchedSortedListItems = fetchedListItems.map {
                listItemToSortedListItemConverterService.convertListItemToSortedListItem(it, supermarketId)
        }

        return listOf(unfetchedSortedListItems, fetchedSortedListItems)
    }
}