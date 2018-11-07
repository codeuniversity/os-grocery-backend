package code.osgroceries.domain.sortedlistitem.services

import code.osgroceries.domain.listitem.ListItem
import code.osgroceries.domain.listitem.createMockListItem
import code.osgroceries.domain.listitem.services.GetUnfetchedAndFetchedListItemsService
import code.osgroceries.domain.row.createMockRow
import code.osgroceries.domain.sortedlistitem.SortedListItem
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner
import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.hasSize
import org.mockito.BDDMockito.given
import org.mockito.Mock

@RunWith(MockitoJUnitRunner::class)
class GetUnfetchedAndFetchedSortedListItemsServiceTest {

    @InjectMocks
    lateinit var getUnfetchedAndFetchedSortedListItemsService: GetUnfetchedAndFetchedSortedListItemsService

    @Mock
    lateinit var getUnfetchedAndFetchedListItemsService: GetUnfetchedAndFetchedListItemsService

    @Mock
    lateinit var listItemToSortedListItemConverterService: ListItemToSortedListItemConverterService

    @Test
    fun `getUnfetchedAndFetchedSortedListItems should return two lists`() {
        // given
        given(getUnfetchedAndFetchedListItemsService.getUnfetchedAndFetchedListItems()).willReturn(givenUnfetchedAndFetchedListItems())

        // when
        val unfetchedAndFetchedSortedListItems = getUnfetchedAndFetchedSortedListItemsService.getUnfetchedAndFetchedSortedListItems()

        // then
        assert.that(unfetchedAndFetchedSortedListItems, hasSize(equalTo(2)))
    }

    @Test
    fun `getUnfetchedAndFetchedSortedListItems should return unfetched and fetched ListItems as SortedListItems`() {
        // given
        val givenUnfetchedAndFetchedListItems = givenUnfetchedAndFetchedListItems()
        given(getUnfetchedAndFetchedListItemsService.getUnfetchedAndFetchedListItems()).willReturn(givenUnfetchedAndFetchedListItems)

        val (unfetchedListItems, fetchedListItems) = givenUnfetchedAndFetchedListItems

        given(listItemToSortedListItemConverterService.convertListItemToSortedListItem(unfetchedListItems[0])).willReturn(
                SortedListItem(unfetchedListItems[0], createMockRow())
        )
        given(listItemToSortedListItemConverterService.convertListItemToSortedListItem(unfetchedListItems[1])).willReturn(
                SortedListItem(unfetchedListItems[1], createMockRow())
        )
        given(listItemToSortedListItemConverterService.convertListItemToSortedListItem(fetchedListItems[0])).willReturn(
                SortedListItem(fetchedListItems[0], createMockRow())
        )
        given(listItemToSortedListItemConverterService.convertListItemToSortedListItem(fetchedListItems[1])).willReturn(
                SortedListItem(fetchedListItems[1], createMockRow())
        )

        // when
        val unfetchedAndFetchedSortedListItems = getUnfetchedAndFetchedSortedListItemsService.getUnfetchedAndFetchedSortedListItems()

        // then
        assert.that(unfetchedAndFetchedSortedListItems, hasSize(equalTo(2)))
        assert.that(unfetchedAndFetchedSortedListItems[0], hasSize(equalTo(givenUnfetchedAndFetchedListItems[0].size)))
        assert.that(unfetchedAndFetchedSortedListItems[1], hasSize(equalTo(givenUnfetchedAndFetchedListItems[1].size)))
        assert.that(unfetchedAndFetchedSortedListItems[0][0].listItem, equalTo(unfetchedListItems[0]))
        assert.that(unfetchedAndFetchedSortedListItems[0][1].listItem, equalTo(unfetchedListItems[1]))
        assert.that(unfetchedAndFetchedSortedListItems[1][0].listItem, equalTo(fetchedListItems[0]))
        assert.that(unfetchedAndFetchedSortedListItems[1][1].listItem, equalTo(fetchedListItems[1]))
    }

    private fun givenUnfetchedAndFetchedListItems(): List<List<ListItem>> {
        return listOf(
                listOf(createMockListItem(), createMockListItem()),
                listOf(createMockListItem(), createMockListItem())
        )
    }
}