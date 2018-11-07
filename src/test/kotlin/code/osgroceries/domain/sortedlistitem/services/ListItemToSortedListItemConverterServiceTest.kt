package code.osgroceries.domain.sortedlistitem.services

import code.osgroceries.domain.listitem.createMockListItem
import code.osgroceries.domain.row.createMockRow
import code.osgroceries.domain.row.services.GetRowService
import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ListItemToSortedListItemConverterServiceTest {

    private val supermarketId: String = "supermarketId"

    @InjectMocks
    lateinit var listItemToSortedListItemConverterService: ListItemToSortedListItemConverterService

    @Mock
    lateinit var getRowService: GetRowService

    @Test
    fun `convertListItemToSortedListItem should convert a ListItem to a SortedListItem`() {
        // given
        val listItem = createMockListItem()

        given(getRowService.getRowByItemIdAndSupermarketId(listItem.itemId, supermarketId)).willReturn(createMockRow())

        // when
        val sortedListItem = listItemToSortedListItemConverterService.convertListItemToSortedListItem(listItem, supermarketId)

        // then
        assert.that(sortedListItem.listItem, equalTo(listItem))
    }

    @Test
    fun `convertListItemToSortedListItem should pick the correct row object for the row field of the SortedListItem`() {
        // given
        val givenRow = createMockRow()
        val listItem = createMockListItem()

        given(getRowService.getRowByItemIdAndSupermarketId(listItem.itemId, supermarketId)).willReturn(givenRow)

        // when
        val sortedListItem = listItemToSortedListItemConverterService.convertListItemToSortedListItem(listItem, supermarketId)

        // then
        assert.that(sortedListItem.row, equalTo(givenRow))
    }
}