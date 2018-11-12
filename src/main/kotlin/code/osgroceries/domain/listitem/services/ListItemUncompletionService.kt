package code.osgroceries.domain.listitem.services

import code.osgroceries.GlobalConfiguration
import code.osgroceries.domain.listitem.ListItem
import code.osgroceries.domain.listitem.ListItemRepository
import code.osgroceries.domain.listitem.exceptions.ListItemNotFoundException
import code.osgroceries.domain.sortedlistitem.SortedListItem
import code.osgroceries.domain.sortedlistitem.services.ListItemToSortedListItemConverterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ListItemUncompletionService @Autowired constructor(
        private val listItemRepository: ListItemRepository,
        private val globalConfiguration: GlobalConfiguration,
        private val listItemToSortedListItemConverterService: ListItemToSortedListItemConverterService
) {

    fun uncompleteListItem(listItemId: String): SortedListItem {
        val optionalListItem = listItemRepository.findById(listItemId)

        if (!optionalListItem.isPresent)
            throw ListItemNotFoundException("ListItem with id $listItemId not found")

        val uncompletedListItem = optionalListItem.get().copy(fetched = false)

        val savedListItem = listItemRepository.save(uncompletedListItem)
        return listItemToSortedListItemConverterService
                .convertListItemToSortedListItem(savedListItem,
                        globalConfiguration.defaultSupermarketId)
    }
}