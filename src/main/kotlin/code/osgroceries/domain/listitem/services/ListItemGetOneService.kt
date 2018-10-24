package code.osgroceries.domain.listitem.services

import code.osgroceries.domain.listitem.actors.ListItemFinder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ListItemGetOneService @Autowired constructor(
        private val listItemFinder: ListItemFinder
) {

    fun getById(id: String) = listItemFinder.findById(id)
}