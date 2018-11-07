package code.osgroceries.domain.listitem

import code.osgroceries.domain.listitem.services.ListItemCompletionService
import code.osgroceries.domain.listitem.services.ListItemUncompletionService
import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ListItemMutationTest {

    @InjectMocks
    lateinit var listItemMutation: ListItemMutation

    @Mock
    lateinit var listItemCompletionService: ListItemCompletionService

    @Mock
    lateinit var listItemUncompletionService: ListItemUncompletionService

    @Test
    fun `completeListItem should complete the listItem with the given Id`() {
        // given
        val listItemId = "listItemId"
        val expectedListItem = ListItem(listItemId, "itemId", Unit.LTR, 8.2, true)

        given(listItemCompletionService.completeListItem(listItemId)).willReturn(expectedListItem)

        // when
        val listItem = listItemMutation.completeListItem(listItemId)

        // then
        assert.that(listItem, equalTo(expectedListItem))
    }

    @Test
    fun `uncompleteListItem should uncomplete the listItem with the given Id`() {
        // given
        val listItemId = "listItemId"
        val expectedListItem = ListItem(listItemId, "itemId", Unit.PACKETS, 4.0, false)

        given(listItemUncompletionService.uncompleteListItem(listItemId)).willReturn(expectedListItem)

        // when
        val listItem = listItemMutation.uncompleteListItem(listItemId)

        // then
        assert.that(listItem, equalTo(expectedListItem))
    }
}