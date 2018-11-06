package code.osgroceries.domain.listitem.services

import code.osgroceries.domain.listitem.ListItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GetListItemsService @Autowired constructor(
        private val listItemRepository: ListItemRepository
) {

    fun getListItems() = listItemRepository.findAll()
}