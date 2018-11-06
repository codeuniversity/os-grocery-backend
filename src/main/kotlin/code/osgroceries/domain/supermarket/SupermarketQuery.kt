package code.osgroceries.domain.supermarket

import code.osgroceries.domain.supermarket.services.GetSupermarketService
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SupermarketQuery @Autowired constructor(
        private val getSupermarketService: GetSupermarketService
) : GraphQLQueryResolver {

    fun getAllSupermarkets(): List<Supermarket> = getSupermarketService.getSupermarkets()
}