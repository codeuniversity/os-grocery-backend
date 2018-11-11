package code.osgroceries.domain.row.services

import code.osgroceries.domain.row.Row
import code.osgroceries.domain.row.RowRepository
import code.osgroceries.util.generateId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CreateRowService @Autowired constructor(
        private val rowRepository: RowRepository
) {

    fun createRow(rowName: String, supermarketId: String): Row {
        val row = Row(generateId(), rowName, supermarketId)
        return rowRepository.insert(row)
    }
}