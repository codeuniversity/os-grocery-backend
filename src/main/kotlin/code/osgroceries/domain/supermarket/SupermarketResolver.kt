package code.osgroceries.domain.supermarket

import code.osgroceries.domain.row.Row
import code.osgroceries.domain.row.services.GetRowService
import code.osgroceries.domain.row.services.GetRowsService
import com.coxautodev.graphql.tools.GraphQLResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SupermarketResolver @Autowired constructor(
        private val getRowsService: GetRowsService
) : GraphQLResolver<Supermarket> {

    fun rows(supermarket: Supermarket): List<Row> = getRowsService.getRowsBySupermarketId(supermarket.id)
}