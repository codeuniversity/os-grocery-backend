package code.osgroceries.domain.row.rowitem

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface RowToItemRepository : MongoRepository<RowItem, String> {

    fun findByRowIdAndItemId(rowId: String, itemId: String): Optional<RowItem>
}