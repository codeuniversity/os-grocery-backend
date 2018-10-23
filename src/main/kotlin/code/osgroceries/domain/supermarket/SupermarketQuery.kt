package code.osgroceries.domain.supermarket

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SupermarketQuery @Autowired constructor(val supermarketRepository: SupermarketRepository) : GraphQLQueryResolver {

    fun getAllSupermarkets() = supermarketRepository.findAll()
}