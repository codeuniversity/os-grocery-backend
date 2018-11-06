package code.osgroceries.domain.item

import code.osgroceries.domain.item.services.GetItemsService
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
class ItemQueryTest {

    @InjectMocks
    lateinit var itemQuery: ItemQuery

    @Mock
    lateinit var getItemsService: GetItemsService

    @Test
    fun `getItems should get all available items`() {
        // given
        val givenItems: List<Item> = listOf(
                Item("0", "zero"),
                Item("1", "one"),
                Item("2", "two")
        )
        given(getItemsService.getItems()).willReturn(givenItems)

        // when
        val items = itemQuery.getItems()

        // then
        assert.that(items, hasSize(equalTo(3)))
        assert.that(items[0], equalTo(givenItems[0]))
        assert.that(items[1], equalTo(givenItems[1]))
        assert.that(items[2], equalTo(givenItems[2]))
    }
}