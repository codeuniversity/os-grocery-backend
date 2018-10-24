package code.osgroceries.domain.listitem

import code.osgroceries.domain.listitem.services.ListItemCreateService
import code.osgroceries.domain.listitem.services.ListItemDeleteService
import code.osgroceries.domain.listitem.services.ListItemRenameService
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ListItemMutation @Autowired constructor(
        val listItemCreateService: ListItemCreateService,
        val listItemRenameService: ListItemRenameService,
        val listItemDeleteService: ListItemDeleteService
) : GraphQLMutationResolver {

    fun createListItem(name: String, shoppingListId: String) =
            listItemCreateService.createListItem(name, shoppingListId)

    fun updateListItem(id: String, name: String) =
            listItemRenameService.renameListItem(id, name)

    fun deleteListItem(id: String) =
            listItemDeleteService.deleteListItem(id)
}
