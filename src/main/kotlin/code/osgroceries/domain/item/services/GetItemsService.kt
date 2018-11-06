package code.osgroceries.domain.item.services

import code.osgroceries.domain.item.Item
import code.osgroceries.domain.item.ItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GetItemsService @Autowired constructor(
        private val itemRepository: ItemRepository
) {

    fun getItems(): List<Item> = itemRepository.findAll()
}