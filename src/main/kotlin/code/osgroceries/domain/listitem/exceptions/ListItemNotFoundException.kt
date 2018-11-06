package code.osgroceries.domain.listitem.exceptions

import code.osgroceries.domain.exceptions.NotFoundException

class ListItemNotFoundException(
        override val message: String
) : NotFoundException(message)