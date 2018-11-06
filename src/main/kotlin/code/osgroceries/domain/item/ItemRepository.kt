package code.osgroceries.domain.item

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository : MongoRepository<Item, String>