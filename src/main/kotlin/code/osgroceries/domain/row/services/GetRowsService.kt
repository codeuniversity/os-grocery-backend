package code.osgroceries.domain.row.services

import code.osgroceries.domain.row.Row
import code.osgroceries.domain.row.RowRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GetRowsService @Autowired constructor(
        private val rowRepository: RowRepository
) {

    fun getRowsBySupermarketId(supermarketId: String): List<Row> = rowRepository.findBySupermarketId(supermarketId)
}