package code.osgroceries.domain.listitem.actors

import code.osgroceries.domain.listitem.ListItem
import code.osgroceries.domain.listitem.ListItemRepository
import code.osgroceries.domain.listitem.exceptions.ListItemNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ListItemUpdater @Autowired constructor(
        private val listItemRepository: ListItemRepository
) {

    fun updateListItem(listItem: ListItem): ListItem {
        if (!listItemRepository.existsById(listItem.id))
            throw ListItemNotFoundException("ListItem with id ${listItem.id} not found.")

        return listItemRepository.save(listItem)
    }
}