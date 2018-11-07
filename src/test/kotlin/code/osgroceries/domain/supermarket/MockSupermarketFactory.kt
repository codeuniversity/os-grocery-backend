package code.osgroceries.domain.supermarket

import code.osgroceries.util.generateId

fun createMockSupermarket(): Supermarket {
    val id = generateId()
    return Supermarket(id = id, name = id)
}