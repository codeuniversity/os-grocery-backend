package code.osgroceries.domain.shoppinglist

import org.springframework.data.mongodb.repository.MongoRepository

interface ShoppingListRepository : MongoRepository<ShoppingList, String>