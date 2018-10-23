package code.osgroceries.domain.supermarket

import org.springframework.data.mongodb.repository.MongoRepository

interface SupermarketRepository : MongoRepository<Supermarket, String>