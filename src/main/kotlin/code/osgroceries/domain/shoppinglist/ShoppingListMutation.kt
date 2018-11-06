package code.osgroceries.domain.shoppinglist

import code.osgroceries.domain.listitem.ListItem
import code.osgroceries.domain.listitem.Unit
import code.osgroceries.domain.listitem.services.ListItemCreationService
import code.osgroceries.domain.listitem.services.ListItemDeletionService
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ShoppingListMutation @Autowired constructor(
        private val listItemCreationService: ListItemCreationService,
        private val listItemDeletionService: ListItemDeletionService
) : GraphQLMutationResolver {

    fun addListItemToList(itemId: String, amount: Double, unit: Unit): ListItem =
            listItemCreationService.createListItem(itemId, amount, unit)

    fun removeListItemFromList(listItemId: String): ListItem =
            listItemDeletionService.deleteListItem(listItemId)
}