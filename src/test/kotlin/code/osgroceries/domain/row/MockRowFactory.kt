package code.osgroceries.domain.row

import code.osgroceries.util.generateId

fun createMockRow(): Row {
    val id = generateId()
    return Row(id = id, name = id, supermarketId = generateId())
}