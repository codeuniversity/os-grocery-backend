package code.osgroceries.domain.listitem

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ListItemQuery @Autowired constructor(val listItemRepository: ListItemRepository) : GraphQLQueryResolver {

    fun getAllListItems() = listItemRepository.findAll()

    fun getOneListItem(id: String) = listItemRepository.findById(id)
}