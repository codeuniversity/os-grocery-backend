package code.osgroceries.domain.shoppinglist

import code.osgroceries.domain.sortedlistitem.SortedListItem

data class SortedShoppingList(
        val unfetchedItems: List<SortedListItem>,
        val fetchedItems: List<SortedListItem>
)