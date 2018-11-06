package code.osgroceries.domain.sortedlistitem

import code.osgroceries.domain.listitem.ListItem
import code.osgroceries.domain.row.Row

data class SortedListItem(
        val listItem: ListItem,
        val row: Row
)