package code.osgroceries.domain.item.services

import code.osgroceries.domain.item.Item
import code.osgroceries.domain.item.ItemRepository
import code.osgroceries.domain.item.exceptions.ItemNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GetItemService @Autowired constructor(
        private val itemRepository: ItemRepository
) {

    @Throws(ItemNotFoundException::class)
    fun getItemById(itemId: String): Item {
        val optionalItem = itemRepository.findById(itemId)

        if (!optionalItem.isPresent)
            throw ItemNotFoundException("Item with id $itemId not found")

        return optionalItem.get()
    }
}
