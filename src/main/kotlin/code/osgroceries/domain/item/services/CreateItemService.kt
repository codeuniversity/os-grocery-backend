package code.osgroceries.domain.item.services

import code.osgroceries.domain.item.Item
import code.osgroceries.domain.item.ItemRepository
import code.osgroceries.domain.row.rowitem.RowItem
import code.osgroceries.domain.row.rowitem.RowToItemRepository
import code.osgroceries.util.generateId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CreateItemService @Autowired constructor(
        private val itemRepository: ItemRepository,
        private val rowToItemRepository: RowToItemRepository
) {

    fun createItemAndMapToRow(itemName: String, rowId: String): Item {
        val item = Item(generateId(), itemName)

        val rowItem = RowItem(generateId(), item.id, rowId)
        rowToItemRepository.insert(rowItem)

        return itemRepository.insert(item)
    }
}