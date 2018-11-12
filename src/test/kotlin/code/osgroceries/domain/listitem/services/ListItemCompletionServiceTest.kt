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
class ListItemCompletionServiceTest {

    @Rule
    @JvmField
    var expectedException: ExpectedException = ExpectedException.none()

    @InjectMocks
    lateinit var listItemCompletionService: ListItemCompletionService

    @Mock
    lateinit var listItemRepository: ListItemRepository

    @Test
    fun `completeListItem should throw ListItemNotFoundException`() {
        // given
        val listItemId = "listItemId"

        // expect
        expectedException.expect(ListItemNotFoundException::class.java)

        // when
        listItemCompletionService.completeListItem(listItemId)
    }

    @Test
    fun `completeListItem should return the list item with the correct id`() {
        // given
        val listItemId = "listItemId"
        val originalListItem = ListItem(listItemId, "itemId", Unit.KG, 2.9, false)

        given(listItemRepository.findById(listItemId)).willReturn(Optional.of(originalListItem))
        given(listItemRepository.save(any<ListItem>())).willReturn(originalListItem.copy(fetched = true))

        // when
        val listItem = listItemCompletionService.completeListItem(listItemId)

        // then
        // assert.that(listItem.id, equalTo(listItemId))
        // assert.that(listItem.fetched, equalTo(true))
    }
}