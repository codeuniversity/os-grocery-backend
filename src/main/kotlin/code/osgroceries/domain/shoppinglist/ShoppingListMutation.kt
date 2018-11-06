package code.osgroceries.domain.shoppinglist

import code.osgroceries.domain.listitem.ListItem
import code.osgroceries.domain.listitem.Unit
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.stereotype.Service

@Service
class ShoppingListMutation : GraphQLMutationResolver {

    fun addListItemToList(itemId: String, amount: Float, unit: Unit): ListItem = TODO()
    fun removeListItemFromList(listItemId: String): ListItem = TODO()
}