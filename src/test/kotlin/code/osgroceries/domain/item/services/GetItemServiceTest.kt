package code.osgroceries.domain.item.services

import code.osgroceries.domain.item.Item
import code.osgroceries.domain.item.ItemRepository
import code.osgroceries.domain.item.exceptions.ItemNotFoundException
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
class GetItemServiceTest {

    private val itemId: String = "itemId"

    @Rule
    @JvmField
    var expectedException: ExpectedException = ExpectedException.none()

    @InjectMocks
    lateinit var getItemService: GetItemService

    @Mock
    lateinit var itemRepository: ItemRepository

    @Test
    fun `getItemById should throw ItemNotFoundException`() {
        // given
        given(itemRepository.findById(itemId)).willReturn(Optional.empty())

        // expect
        expectedException.expect(ItemNotFoundException::class.java)

        // when
        getItemService.getItemById(itemId)
    }

    @Test
    fun `getItemById should get the Item by its id`() {
        // given
        val expectedItem = Item(itemId, "itemName")
        given(itemRepository.findById(itemId)).willReturn(Optional.of(expectedItem))

        // when
        val item = getItemService.getItemById(itemId)

        // then
        assert.that(item, equalTo(expectedItem))
    }
}