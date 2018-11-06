package code.osgroceries.domain.supermarket

import code.osgroceries.domain.row.Row
import com.coxautodev.graphql.tools.GraphQLResolver
import org.springframework.stereotype.Service

@Service
class SupermarketResolver : GraphQLResolver<Supermarket> {

    fun rows(supermarket: Supermarket): List<Row> = TODO()
}