package code.osgroceries.domain.item

import code.osgroceries.domain.item.services.GetItemsService
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ItemQuery @Autowired constructor(
        private val getItemsService: GetItemsService
) : GraphQLQueryResolver {

    fun getItems(): List<Item> = getItemsService.getItems()
}