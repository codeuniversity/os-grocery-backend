package code.osgroceries.domain.row

import code.osgroceries.domain.supermarket.Supermarket
import com.coxautodev.graphql.tools.GraphQLResolver
import org.springframework.stereotype.Service

@Service
class RowResolver : GraphQLResolver<Row> {

    fun supermarket(row: Row): Supermarket = TODO()
}