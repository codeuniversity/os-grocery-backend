package code.osgroceries.domain.sortedlistitem.services

import code.osgroceries.domain.listitem.ListItem
import code.osgroceries.domain.row.services.GetRowService
import code.osgroceries.domain.sortedlistitem.SortedListItem
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ListItemToSortedListItemConverterService @Autowired constructor(
        private val getRowService: GetRowService
) {

    fun convertListItemToSortedListItem(listItem: ListItem, supermarketId: String): SortedListItem {
        val row = getRowService.getRowByItemIdAndSupermarketId(listItem.itemId, supermarketId)
        return SortedListItem(listItem, row)
    }
}
