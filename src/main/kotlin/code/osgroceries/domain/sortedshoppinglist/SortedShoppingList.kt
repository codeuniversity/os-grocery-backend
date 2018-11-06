package code.osgroceries.domain.sortedshoppinglist

import code.osgroceries.domain.sortedlistitem.SortedListItem

data class SortedShoppingList(
        val unfetchedItems: List<SortedListItem>,
        val fetchedItems: List<SortedListItem>
)