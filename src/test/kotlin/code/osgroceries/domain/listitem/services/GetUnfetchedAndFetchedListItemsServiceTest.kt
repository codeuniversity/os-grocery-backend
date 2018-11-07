package code.osgroceries.domain.listitem.services

import code.osgroceries.domain.listitem.ListItem
import code.osgroceries.domain.listitem.randomUnit
import code.osgroceries.domain.shoppinglist.ShoppingList
import code.osgroceries.domain.shoppinglist.services.GetShoppingListService
import code.osgroceries.util.generateId
import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.hasSize
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class GetUnfetchedAndFetchedListItemsServiceTest {

    @InjectMocks
    lateinit var getUnfetchedAndFetchedListItemsService: GetUnfetchedAndFetchedListItemsService

    @Mock
    lateinit var getShoppingListService: GetShoppingListService

    @Test
    fun `getUnfetchedAndFetchedListItems should return a list with two items`() {
        // given
        val givenShoppingList = ShoppingList(emptyList())
        given(getShoppingListService.getShoppingList()).willReturn(givenShoppingList)

        // when
        val unfetchedAndFetchedListItems = getUnfetchedAndFetchedListItemsService.getUnfetchedAndFetchedListItems()

        // then
        assert.that(unfetchedAndFetchedListItems, hasSize(equalTo(2)))
    }

    @Test
    fun `getUnfetchedAndFetchedListItems should return correctly sorted ListItems`() {
        // given
        val givenShoppingList = ShoppingList(listOf(
                ListItem(generateId(), generateId(), randomUnit(), Random().nextDouble(), false),
                ListItem(generateId(), generateId(), randomUnit(), Random().nextDouble(), false),
                ListItem(generateId(), generateId(), randomUnit(), Random().nextDouble(), false),
                ListItem(generateId(), generateId(), randomUnit(), Random().nextDouble(), true),
                ListItem(generateId(), generateId(), randomUnit(), Random().nextDouble(), true),
                ListItem(generateId(), generateId(), randomUnit(), Random().nextDouble(), true),
                ListItem(generateId(), generateId(), randomUnit(), Random().nextDouble(), true)
        ))
        given(getShoppingListService.getShoppingList()).willReturn(givenShoppingList)

        // when
        val (unfetchedListItems, fetchedListItems) = getUnfetchedAndFetchedListItemsService.getUnfetchedAndFetchedListItems()

        // then
        assert.that(unfetchedListItems, hasSize(equalTo(3)))
        assert.that(fetchedListItems, hasSize(equalTo(4)))
    }
}