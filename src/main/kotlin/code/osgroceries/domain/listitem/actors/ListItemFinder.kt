package code.osgroceries.domain.listitem.actors

import code.osgroceries.domain.listitem.ListItem

import code.osgroceries.domain.listitem.ListItemRepository
import code.osgroceries.domain.listitem.exceptions.ListItemNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ListItemFinder @Autowired constructor(
        private val listItemRepository: ListItemRepository
) {

    fun findAll(): List<ListItem> {
        val allListItems = listItemRepository.findAll()
        return allListItems.filter { it != null }
    }

    fun findById(id: String): ListItem {
        val optionalListItem = listItemRepository.findById(id)

        if (!optionalListItem.isPresent)
            throw ListItemNotFoundException("ListItem with id $id could not be found.")

        return optionalListItem.get()
    }

    fun findByShoppingListId(shoppingListId: String) =
        listItemRepository.findByShoppingListId(shoppingListId)
}
