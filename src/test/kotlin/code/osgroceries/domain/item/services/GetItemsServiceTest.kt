package code.osgroceries.domain.item.services

import code.osgroceries.domain.item.Item
import code.osgroceries.domain.item.ItemRepository
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
class GetItemsServiceTest {

    @InjectMocks
    lateinit var getItemsService: GetItemsService

    @Mock
    lateinit var itemRepository: ItemRepository

    @Test
    fun `getItems should get all available items`() {
        // given
        val givenItems = listOf(
                Item("0", "zero"),
                Item("1", "one"),
                Item("2", "two")
        )
        given(itemRepository.findAll()).willReturn(givenItems)

        // when
        val items = getItemsService.getItems()

        // then
        assert.that(items, hasSize(equalTo(givenItems.size)))
        assert.that(items[0], equalTo(givenItems[0]))
        assert.that(items[1], equalTo(givenItems[1]))
        assert.that(items[2], equalTo(givenItems[2]))
    }
}