package code.osgroceries.domain.listitem.services

import code.osgroceries.domain.listitem.ListItem
import code.osgroceries.domain.listitem.ListItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ListItemDeletionService @Autowired constructor(
        private val getListItemService: GetListItemService,
        private val listItemRepository: ListItemRepository
) {

    fun deleteListItem(listItemId: String): ListItem {
        val listItem = getListItemService.getListItemById(listItemId)
        listItemRepository.delete(listItem)
        return listItem
    }
}