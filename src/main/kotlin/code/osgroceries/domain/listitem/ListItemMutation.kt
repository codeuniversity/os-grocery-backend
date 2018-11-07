package code.osgroceries.domain.listitem

import code.osgroceries.domain.listitem.services.ListItemCompletionService
import code.osgroceries.domain.listitem.services.ListItemUncompletionService
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ListItemMutation @Autowired constructor(
        private val listItemCompletionService: ListItemCompletionService,
        private val listItemUncompletionService: ListItemUncompletionService
) : GraphQLMutationResolver {

    fun completeListItem(listItemId: String): ListItem = listItemCompletionService.completeListItem(listItemId)

    fun uncompleteListItem(listItemId: String): ListItem = listItemUncompletionService.uncompleteListItem(listItemId)
}