package code.osgroceries.domain.listitem

import code.osgroceries.util.generateId
import java.util.*

fun createMockListItem(): ListItem = ListItem(
        id = generateId(),
        itemId = generateId(),
        unit = randomUnit(),
        amount = Random().nextDouble(),
        fetched = Random().nextBoolean()
)