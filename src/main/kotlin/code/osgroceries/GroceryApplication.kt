package code.osgroceries

import code.osgroceries.domain.item.Item
import code.osgroceries.domain.listitem.ListItem
import code.osgroceries.domain.listitem.Unit
import code.osgroceries.domain.shoppinglist.ShoppingList
import code.osgroceries.domain.shoppinglist.SortedShoppingList
import code.osgroceries.domain.supermarket.Supermarket
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Service

@SpringBootApplication
class GroceryApplication

fun main(args: Array<String>) {
    runApplication<GroceryApplication>(*args)
}

@Service
class TemporaryGraphQLQueryResolver : GraphQLQueryResolver {

    fun getItems(): List<Item> = TODO()
    fun getShoppingList(): ShoppingList = TODO()
    fun getSortedShoppingList(): SortedShoppingList = TODO()

    fun getAllSupermarkets(): List<Supermarket> = TODO()
}

@Service
class TemporaryGraphQLMutationResolver : GraphQLMutationResolver {

    fun addListItemToList(itemId: String, amount: Float, unit: Unit): ListItem = TODO()
    fun removeListItemFromList(listItemId: String): ListItem = TODO()
    fun completeListItem(listItemId: String): ListItem = TODO()
    fun uncompleteListItem(listItemId: String): ListItem = TODO()
}
