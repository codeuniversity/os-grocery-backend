package code.osgroceries.domain.listitem

import code.osgroceries.domain.shoppinglist.services.ShoppingListGetOneService
import com.coxautodev.graphql.tools.GraphQLResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ListItemResolver @Autowired constructor(
        private val shoppingListGetOneService: ShoppingListGetOneService
) : GraphQLResolver<ListItem> {

    fun shoppingList(listItem: ListItem) = shoppingListGetOneService.getById(listItem.shoppingListId)
}
