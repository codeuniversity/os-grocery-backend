package code.osgroceries.domain.listitem.services

import code.osgroceries.domain.listitem.ListItem
import code.osgroceries.domain.listitem.ListItemRepository
import code.osgroceries.domain.listitem.Unit
import code.osgroceries.domain.listitem.exceptions.ListItemNotFoundException
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
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class ListItemUncompletionServiceTest {

    @Rule
    @JvmField
    var expectedException: ExpectedException = ExpectedException.none()

    @InjectMocks
    lateinit var listItemUncompletionService: ListItemUncompletionService

    @Mock
    lateinit var listItemRepository: ListItemRepository

    @Test
    fun `uncompleteListItem should throw ListItemNotFoundException`() {
        // given
        val listItemId = "listItemId"

        // expect
        expectedException.expect(ListItemNotFoundException::class.java)

        // when
        listItemUncompletionService.uncompleteListItem(listItemId)
    }

    @Test
    fun `uncompleteListItem should uncomplete the ListItem with the given id`() {
        // given
        val listItemId = "listItemId"
        val givenListItem = ListItem(listItemId, "itemId", Unit.ML, 300.3, true)

        given(listItemRepository.findById(listItemId)).willReturn(Optional.of(givenListItem))
        given(listItemRepository.save(any<ListItem>())).willReturn(givenListItem.copy(fetched = false))

        // when
        val listItem = listItemUncompletionService.uncompleteListItem(listItemId)

        // then
        assert.that(listItem.id, equalTo(listItemId))
        assert.that(listItem.fetched, equalTo(false))
    }
}