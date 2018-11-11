package code.osgroceries.domain.row

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface RowRepository : MongoRepository<Row, String> {

    fun findBySupermarketId(supermarketId: String): List<Row>
}
