package code.osgroceries.domain.listitem.services

import code.osgroceries.domain.item.ItemRepository
import code.osgroceries.domain.item.exceptions.ItemNotFoundException
import code.osgroceries.domain.listitem.ListItem
import code.osgroceries.domain.listitem.ListItemRepository
import code.osgroceries.domain.listitem.Unit
import code.osgroceries.util.generateId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ListItemCreationService @Autowired constructor(
        private val listItemRepository: ListItemRepository,
        private val itemRepository: ItemRepository
) {

    fun createListItem(itemId: String, amount: Double, unit: Unit): ListItem {
        if (!itemRepository.findById(itemId).isPresent) throw ItemNotFoundException("Item with id $itemId not found.")

        val listItem = ListItem(generateId(), itemId, unit, amount, false)
        return listItemRepository.insert(listItem)
    }
}