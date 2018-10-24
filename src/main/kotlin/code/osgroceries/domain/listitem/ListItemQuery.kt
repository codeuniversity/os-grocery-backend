package code.osgroceries.domain.listitem

import code.osgroceries.domain.listitem.services.ListItemGetAllService
import code.osgroceries.domain.listitem.services.ListItemGetOneService
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ListItemQuery @Autowired constructor(
        private val listItemGetAllService: ListItemGetAllService,
        private val listItemGetOneService: ListItemGetOneService
) : GraphQLQueryResolver {

    fun getAllListItems() = listItemGetAllService.getAll()

    fun getOneListItem(id: String) = listItemGetOneService.getById(id)
}
