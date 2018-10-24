package code.osgroceries.domain.listitem.services

import code.osgroceries.domain.listitem.ListItem
import code.osgroceries.domain.listitem.actors.ListItemCreator
import code.osgroceries.util.generateId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ListItemCreateService @Autowired constructor(
        val listItemCreator: ListItemCreator
) {

    fun createListItem(name: String, shoppingListId: String): ListItem {
        val id = generateId()
        return listItemCreator.createListItem(id, name, shoppingListId)
    }
}
