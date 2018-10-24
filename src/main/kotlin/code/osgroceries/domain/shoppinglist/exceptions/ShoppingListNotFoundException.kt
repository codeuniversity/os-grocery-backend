package code.osgroceries.domain.shoppinglist.exceptions

import code.osgroceries.domain.exceptions.NotFoundException

class ShoppingListNotFoundException(override val message: String) : NotFoundException(message)
