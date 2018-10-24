package code.osgroceries.domain.listitem.services

import code.osgroceries.domain.listitem.actors.ListItemFinder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ListItemGetAllService @Autowired constructor(
        private val listItemFinder: ListItemFinder
) {

    fun getAll() = listItemFinder.findAll()

    fun getAllInShoppingListWithId(shoppingListId: String) =
        listItemFinder.findByShoppingListId(shoppingListId)
}