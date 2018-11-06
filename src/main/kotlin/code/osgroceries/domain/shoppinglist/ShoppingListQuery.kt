package code.osgroceries.domain.shoppinglist

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Service

@Service
class ShoppingListQuery : GraphQLQueryResolver {

    fun getShoppingList(): ShoppingList = TODO()
}