package code.osgroceries.domain.sortedshoppinglist.services

import code.osgroceries.domain.sortedlistitem.createMockSortedListItem
import code.osgroceries.domain.sortedlistitem.services.GetUnfetchedAndFetchedSortedListItemsService
import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.hasSize
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetSortedShoppingListServiceTest {

    @InjectMocks
    lateinit var getSortedShoppingListService: GetSortedShoppingListService

    @Mock
    lateinit var getUnfetchedAndFetchedSortedListItemsService: GetUnfetchedAndFetchedSortedListItemsService

    @Test
    fun `getSortedShoppingList should get the ShoppingList as SortedShoppingList`() {
        // given
        given(getUnfetchedAndFetchedSortedListItemsService.getUnfetchedAndFetchedSortedListItems()).willReturn(
                listOf(
                        listOf(createMockSortedListItem(), createMockSortedListItem()),
                        listOf(createMockSortedListItem(), createMockSortedListItem())
                )
        )

        // when
        val sortedShoppingList = getSortedShoppingListService.getSortedShoppingList()

        // then
        assert.that(sortedShoppingList.unfetchedItems, hasSize(equalTo(2)))
        assert.that(sortedShoppingList.fetchedItems, hasSize(equalTo(2)))
    }
}