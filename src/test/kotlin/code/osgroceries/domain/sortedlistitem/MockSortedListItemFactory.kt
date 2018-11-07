package code.osgroceries.domain.sortedlistitem

import code.osgroceries.domain.listitem.createMockListItem
import code.osgroceries.domain.row.createMockRow

fun createMockSortedListItem(): SortedListItem = SortedListItem(createMockListItem(), createMockRow())