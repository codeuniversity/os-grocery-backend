package code.osgroceries.domain.shoppinglist

import code.osgroceries.domain.listitem.ListItem
import code.osgroceries.domain.listitem.services.GetListItemsService
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ShoppingListQuery @Autowired constructor(
        private val getListItemsService: GetListItemsService
) : GraphQLQueryResolver {

    fun getShoppingList(): ShoppingList {
        val listItems: List<ListItem> = getListItemsService.getListItems()
        return ShoppingList(listItems)
    }
}