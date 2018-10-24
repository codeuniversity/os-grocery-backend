package code.osgroceries.domain.supermarket

import code.osgroceries.domain.supermarket.services.SupermarketGetAllService
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SupermarketQuery @Autowired constructor(
        private val supermarketGetAllService: SupermarketGetAllService
) : GraphQLQueryResolver {

    fun getAllSupermarkets() = supermarketGetAllService.getAll()
}
