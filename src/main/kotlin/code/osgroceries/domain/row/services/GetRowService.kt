package code.osgroceries.domain.row.services

import code.osgroceries.domain.item.services.GetItemService
import code.osgroceries.domain.row.Row
import code.osgroceries.domain.row.RowRepository
import code.osgroceries.domain.row.exceptions.RowNotFoundException
import code.osgroceries.domain.row.rowitem.RowToItemRepository
import code.osgroceries.domain.supermarket.exceptions.ItemNotInSupermarketException
import code.osgroceries.domain.supermarket.services.GetSupermarketService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GetRowService @Autowired constructor(
        private val getItemService: GetItemService,
        private val getSupermarketService: GetSupermarketService,
        private val rowToItemRepository: RowToItemRepository,
        private val rowRepository: RowRepository
) {

    fun getRowByItemIdAndSupermarketId(itemId: String, supermarketId: String): Row {
        getItemService.getItemById(itemId)
        getSupermarketService.getSupermarketById(supermarketId)

        val rowIds = rowRepository.findBySupermarketId(supermarketId).map { it.id }
        val optionalRowItem = rowToItemRepository.findByRowIdsAndItemId(rowIds, itemId)

        if (!optionalRowItem.isPresent)
            throw ItemNotInSupermarketException("Item with id $itemId cannot be found in supermarket with id $supermarketId.")

        return getRowById(optionalRowItem.get().rowId)
    }

    fun getRowById(rowId: String): Row {
        val optionalRow = rowRepository.findById(rowId)

        if (!optionalRow.isPresent)
            throw RowNotFoundException("Row with id $rowId not found.")

        return optionalRow.get()
    }
}
