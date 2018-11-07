package code.osgroceries.domain.item

import code.osgroceries.util.generateId

fun createMockItem(): Item {
    val id = generateId()
    return Item(id = id, name = id)
}