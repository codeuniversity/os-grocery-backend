package code.osgroceries.domain.item.exceptions

import code.osgroceries.domain.exceptions.NotFoundException

class ItemNotFoundException(
        override val message: String
) : NotFoundException(message)