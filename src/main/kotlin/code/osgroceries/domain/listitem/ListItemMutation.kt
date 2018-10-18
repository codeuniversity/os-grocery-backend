package code.osgroceries.domain.listitem

import code.osgroceries.util.generateId
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.io.IOException

@Service
class ListItemMutation @Autowired constructor(val listItemRepository: ListItemRepository) : GraphQLMutationResolver {

    fun createListItem(name: String) = listItemRepository.insert(ListItem(generateId(), name))

    fun updateListItem(id: String, name: String): ListItem {
        val optionalListItem = listItemRepository.findById(id)

        if (!optionalListItem.isPresent)
            throw IOException()

        val listItem = optionalListItem.get()
        val updatedListItem = ListItem(listItem.id, name)
        listItemRepository.save(updatedListItem)

        return updatedListItem
    }

    fun deleteListItem(id: String): String {
        listItemRepository.deleteById(id)
        return id
    }
}