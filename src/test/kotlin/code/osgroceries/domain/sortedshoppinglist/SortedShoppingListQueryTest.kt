package code.osgroceries.domain.sortedshoppinglist

import code.osgroceries.domain.sortedlistitem.SortedListItem
import code.osgroceries.domain.sortedshoppinglist.services.GetSortedShoppingListService
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner
import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import org.mockito.BDDMockito.given
import org.mockito.Mock

@RunWith(MockitoJUnitRunner::class)
class SortedShoppingListQueryTest {

    @InjectMocks
    lateinit var sortedShoppingListQuery: SortedShoppingListQuery

    @Mock
    lateinit var getSortedShoppingListService: GetSortedShoppingListService

    @Test
    fun `getSortedShoppingList should return the sorted ShoppingList`() {
        // given
        val unfetchedItems = listOf<SortedListItem>()
        val fetchedItems = listOf<SortedListItem>()
        val expectedSortedShoppingList = SortedShoppingList(unfetchedItems, fetchedItems)

        given(getSortedShoppingListService.getSortedShoppingList()).willReturn(expectedSortedShoppingList)

        // when
        val sortedShoppingList = sortedShoppingListQuery.getSortedShoppingList()

        // then
        assert.that(sortedShoppingList, equalTo(expectedSortedShoppingList))
    }
}