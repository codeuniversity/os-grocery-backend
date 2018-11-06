package code.osgroceries.domain.listitem

import code.osgroceries.domain.item.Item
import com.coxautodev.graphql.tools.GraphQLResolver
import org.springframework.stereotype.Service

@Service
class ListItemResolver : GraphQLResolver<ListItem> {

    fun item(listItem: ListItem): Item = TODO()
}
