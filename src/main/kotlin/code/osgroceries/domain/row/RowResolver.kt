package code.osgroceries.domain.row

import code.osgroceries.domain.supermarket.Supermarket
import code.osgroceries.domain.supermarket.services.GetSupermarketService
import com.coxautodev.graphql.tools.GraphQLResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RowResolver @Autowired constructor(
        private val getSupermarketService: GetSupermarketService
) : GraphQLResolver<Row> {

    fun supermarket(row: Row): Supermarket = getSupermarketService.getSupermarketById(row.supermarketId)
}