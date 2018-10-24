package code.osgroceries.domain.listitem.actors

import code.osgroceries.domain.listitem.ListItem
import code.osgroceries.domain.listitem.ListItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ListItemCreator @Autowired constructor(
        private val listItemRepository: ListItemRepository
) {

    fun createListItem(id: String, name: String, shoppingListId: String): ListItem {
        val listItem = ListItem(id, name, shoppingListId)
        return listItemRepository.insert(listItem)
    }
}
