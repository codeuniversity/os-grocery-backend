package code.osgroceries.domain.row.exceptions

import code.osgroceries.domain.exceptions.NotFoundException

class RowNotFoundException(
        message: String
) : NotFoundException(message)