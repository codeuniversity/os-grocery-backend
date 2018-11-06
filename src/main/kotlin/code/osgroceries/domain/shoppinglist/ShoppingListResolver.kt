package code.osgroceries.domain.shoppinglist

import code.osgroceries.domain.item.Item
import com.coxautodev.graphql.tools.GraphQLResolver
import org.springframework.stereotype.Service

@Service
class ShoppingListResolver : GraphQLResolver<ShoppingList> {

    fun items(shoppingList: ShoppingList): List<Item> = TODO()
}
