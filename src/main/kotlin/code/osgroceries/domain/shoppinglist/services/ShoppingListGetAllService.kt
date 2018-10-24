package code.osgroceries.domain.shoppinglist.services

import code.osgroceries.domain.shoppinglist.actors.ShoppingListFinder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ShoppingListGetAllService @Autowired constructor(
        private val shoppingListFinder: ShoppingListFinder
) {

    fun getAll() = shoppingListFinder.findAll()
}