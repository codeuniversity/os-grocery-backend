package code.osgroceries.domain.supermarket.exceptions

import code.osgroceries.domain.exceptions.NotFoundException

class SupermarketNotFoundException(
        message: String
) : NotFoundException(message)
