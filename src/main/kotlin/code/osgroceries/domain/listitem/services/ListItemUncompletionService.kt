package code.osgroceries.domain.listitem.services

import code.osgroceries.domain.listitem.ListItem
import code.osgroceries.domain.listitem.ListItemRepository
import code.osgroceries.domain.listitem.exceptions.ListItemNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ListItemUncompletionService @Autowired constructor(
        private val listItemRepository: ListItemRepository
) {

    fun uncompleteListItem(listItemId: String): ListItem {
        val optionalListItem = listItemRepository.findById(listItemId)

        if (!optionalListItem.isPresent)
            throw ListItemNotFoundException("ListItem with id $listItemId not found")

        val uncompletedListItem = optionalListItem.get().copy(fetched = false)

        return listItemRepository.save(uncompletedListItem)
    }
}