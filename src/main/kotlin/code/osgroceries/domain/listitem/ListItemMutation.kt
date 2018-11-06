package code.osgroceries.domain.listitem

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.stereotype.Service

@Service
class ListItemMutation : GraphQLMutationResolver {

    fun completeListItem(listItemId: String): ListItem = TODO()
    fun uncompleteListItem(listItemId: String): ListItem = TODO()
}