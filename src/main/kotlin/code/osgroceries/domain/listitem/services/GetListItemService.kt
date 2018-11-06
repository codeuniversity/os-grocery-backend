package code.osgroceries.domain.listitem.services

import code.osgroceries.domain.listitem.ListItem
import code.osgroceries.domain.listitem.ListItemRepository
import code.osgroceries.domain.listitem.exceptions.ListItemNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GetListItemService @Autowired constructor(
        private val listItemRepository: ListItemRepository
) {

    @Throws(ListItemNotFoundException::class)
    fun getListItemById(listItemId: String): ListItem {
        val optionalListItem = listItemRepository.findById(listItemId)
        if (!optionalListItem.isPresent) throw ListItemNotFoundException("ListItem with $listItemId not found.")
        return optionalListItem.get()
    }
}