package code.osgroceries.domain.listitem

import java.util.*

fun randomUnit(): Unit {
    val pick = Random().nextInt(Unit.values().size)
    return Unit.values()[pick]
}