package code.osgroceries.domain.row.rowitem

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface RowToItemRepository : MongoRepository<RowItem, String> {

    fun findByRowIdsAndItemId(rowIds: List<String>, itemId: String): Optional<RowItem> {
        rowIds.forEach {
            val optionalRowItem = findByRowIdAndItemId(it, itemId)

            if (optionalRowItem.isPresent)
                return optionalRowItem
        }

        return Optional.empty()
    }

    fun findByRowIdAndItemId(rowId: String, itemId: String): Optional<RowItem>
}