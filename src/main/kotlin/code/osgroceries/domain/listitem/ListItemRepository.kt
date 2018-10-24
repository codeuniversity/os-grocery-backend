package code.osgroceries.domain.listitem

import org.springframework.data.mongodb.repository.MongoRepository

interface ListItemRepository : MongoRepository<ListItem, String> {

    fun findByShoppingListId(shoppingListId: String): List<ListItem>
}
