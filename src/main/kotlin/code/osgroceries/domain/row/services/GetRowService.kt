package code.osgroceries.domain.row.services

import code.osgroceries.domain.item.services.GetItemService
import code.osgroceries.domain.row.Row
import code.osgroceries.domain.row.RowRepository
import code.osgroceries.domain.row.exceptions.RowNotFoundException
import code.osgroceries.domain.row.supermarketitem.SupermarketToItemRepository
import code.osgroceries.domain.supermarket.exceptions.ItemNotInSupermarketException
import code.osgroceries.domain.supermarket.services.GetSupermarketService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GetRowService @Autowired constructor(
        private val getItemService: GetItemService,
        private val getSupermarketService: GetSupermarketService,
        private val supermarketToItemRepository: SupermarketToItemRepository,
        private val rowRepository: RowRepository
) {

    fun getRowByItemIdAndSupermarketId(itemId: String, supermarketId: String): Row {
        getItemService.getItemById(itemId)
        getSupermarketService.getSupermarketById(supermarketId)
        val supermarketItem = supermarketToItemRepository.findBySupermarketIdAndItemId(supermarketId, itemId)
                ?: throw ItemNotInSupermarketException("Item with id $itemId cannot be found in supermarket with id $supermarketId.")
        return getRowById(supermarketItem.rowId)
    }

    fun getRowById(rowId: String): Row {
        val optionalRow = rowRepository.findById(rowId)

        if (!optionalRow.isPresent)
            throw RowNotFoundException("Row with id $rowId not found.")

        return optionalRow.get()
    }
}
