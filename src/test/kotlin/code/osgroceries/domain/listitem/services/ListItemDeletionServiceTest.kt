package code.osgroceries.domain.listitem.services

import code.osgroceries.domain.listitem.ListItem
import code.osgroceries.domain.listitem.ListItemRepository
import code.osgroceries.domain.listitem.Unit
import code.osgroceries.domain.listitem.exceptions.ListItemNotFoundException
import com.natpryce.hamkrest.Matcher
import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.any
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ListItemDeletionServiceTest {

    @Rule
    @JvmField
    var expectedException: ExpectedException = ExpectedException.none()

    @InjectMocks
    lateinit var listItemDeletionService: ListItemDeletionService

    @Mock
    lateinit var getListItemService: GetListItemService

    @Mock
    lateinit var listItemRepository: ListItemRepository

    @Test
    fun `deleteListItem should throw ListItemNotFoundException`() {
        // given
        val listItemId = "listItemId"

        given(getListItemService.getListItemById(listItemId))
                .willThrow(ListItemNotFoundException::class.java)

        // expect
        expectedException.expect(ListItemNotFoundException::class.java)

        // when
        listItemDeletionService.deleteListItem(listItemId)
    }

    @Test
    fun `deleteListItem should delete ListItem with passed id from repository`() {
        // given
        val listItemId = "listItemId"
        val givenListItem = ListItem(listItemId, "itemId", Unit.KG, 4.3, false)

        val listItems = mutableListOf(givenListItem)
        mockListItemRepository_delete(listItems)
        mockListItemRepository_findAll(listItems)

        given(getListItemService.getListItemById(listItemId)).willReturn(givenListItem)

        // when
        val listItem = listItemDeletionService.deleteListItem(listItemId)

        // then
        assert.that(listItem.id, equalTo(listItemId))

        val contains = Matcher(List<ListItem>::contains)
        assert.that(listItemRepository.findAll(), !contains(listItem))
    }

    private fun mockListItemRepository_delete(listItems: MutableList<ListItem>) {
        given(listItemRepository.delete(any(ListItem::class.java))).willAnswer {
            val listItem = it.arguments[0] as ListItem

            if (listItems.remove(listItem)) {
                listItem
            } else {
                null
            }
        }
    }

    private fun mockListItemRepository_findAll(listItems: MutableList<ListItem>) {
        given(listItemRepository.findAll()).willReturn(listItems)
    }
}