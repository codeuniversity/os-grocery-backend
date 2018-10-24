package code.osgroceries.domain.listitem.services

import code.osgroceries.domain.listitem.ListItem
import code.osgroceries.domain.listitem.actors.ListItemFinder
import code.osgroceries.domain.listitem.actors.ListItemUpdater
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ListItemRenameService @Autowired constructor(
        val listItemFinder: ListItemFinder,
        val listItemUpdater: ListItemUpdater
) {

    fun renameListItem(id: String, name: String): ListItem {
        val listItem = listItemFinder.findById(id)
        val updatedListItem = ListItem(listItem.id, name, listItem.shoppingListId)
        return listItemUpdater.updateListItem(updatedListItem)
    }
}
