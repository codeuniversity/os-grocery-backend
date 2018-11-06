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
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class GetListItemServiceTest {

    @Rule
    @JvmField
    var expectedException: ExpectedException = ExpectedException.none()

    @InjectMocks
    lateinit var getListItemService: GetListItemService

    @Mock
    lateinit var listItemRepository: ListItemRepository

    @Test
    fun `getListItemById should throw ListItemNotFoundException`() {
        // given
        val listItemId = "listItemId"

        // expect
        expectedException.expect(ListItemNotFoundException::class.java)

        // when
        getListItemService.getListItemById(listItemId)
    }

    @Test
    fun `getListItemById should find a ListItem by id`() {
        // given
        val listItemId = "listItemId"
        val givenListItem = ListItem(listItemId, "itemId", Unit.KG, 3.4, false)

        given(listItemRepository.findById(listItemId)).willReturn(Optional.of(givenListItem))

        // when
        val listItem = getListItemService.getListItemById(listItemId)

        // then
        assert.that(listItem, equalTo(givenListItem))
    }
}