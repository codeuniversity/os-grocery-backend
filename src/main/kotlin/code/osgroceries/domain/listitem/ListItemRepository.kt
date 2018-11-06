package code.osgroceries.domain.listitem

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ListItemRepository : MongoRepository<ListItem, String>