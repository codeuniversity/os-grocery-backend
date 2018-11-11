package code.osgroceries.domain.row.rowitem.services

import code.osgroceries.domain.row.rowitem.RowItem
import code.osgroceries.domain.row.rowitem.RowToItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class FindRowItemService @Autowired constructor(
        private val rowToItemRepository: RowToItemRepository
) {

    fun findByRowIdsAndItemId(rowIds: List<String>, itemId: String): Optional<RowItem> {
        rowIds.forEach {
            val optionalRowItem = rowToItemRepository.findByRowIdAndItemId(it, itemId)

            if (optionalRowItem.isPresent)
                return optionalRowItem
        }

        return Optional.empty()
    }
}