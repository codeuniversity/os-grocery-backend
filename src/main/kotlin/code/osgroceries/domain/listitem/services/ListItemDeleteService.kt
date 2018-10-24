package code.osgroceries.domain.listitem.services

import code.osgroceries.domain.listitem.actors.ListItemDeleter
import code.osgroceries.domain.listitem.actors.ListItemFinder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ListItemDeleteService @Autowired constructor(
        val listItemFinder: ListItemFinder,
        val listItemDeleter: ListItemDeleter
) {

    fun deleteListItem(id: String): String {
        val listItem = listItemFinder.findById(id)
        listItemDeleter.deleteListItem(listItem)
        return listItem.id
    }
}