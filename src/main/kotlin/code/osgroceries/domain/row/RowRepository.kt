package code.osgroceries.domain.row

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface RowRepository : MongoRepository<Row, String>
