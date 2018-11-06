package code.osgroceries.domain.supermarket

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface SupermarketRepository : MongoRepository<Supermarket, String>