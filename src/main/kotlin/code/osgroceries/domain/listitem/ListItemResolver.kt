package code.osgroceries.domain.listitem

import code.osgroceries.domain.item.Item
import code.osgroceries.domain.item.services.GetItemService
import com.coxautodev.graphql.tools.GraphQLResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ListItemResolver @Autowired constructor(
        private val getItemService: GetItemService
) : GraphQLResolver<ListItem> {

    fun item(listItem: ListItem): Item = getItemService.getItemById(listItem.itemId)
}
