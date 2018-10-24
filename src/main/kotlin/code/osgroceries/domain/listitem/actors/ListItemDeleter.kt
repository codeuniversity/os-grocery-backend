package code.osgroceries.domain.listitem.actors

import code.osgroceries.domain.listitem.ListItem
import code.osgroceries.domain.listitem.ListItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ListItemDeleter @Autowired constructor(
        private val listItemRepository: ListItemRepository
) {

    fun deleteListItem(listItem: ListItem) =
            listItemRepository.delete(listItem)
}
