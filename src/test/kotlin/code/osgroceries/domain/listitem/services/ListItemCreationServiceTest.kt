package code.osgroceries.domain.listitem.services

import code.osgroceries.domain.item.Item
import code.osgroceries.domain.item.ItemRepository
import code.osgroceries.domain.item.exceptions.ItemNotFoundException
import code.osgroceries.domain.listitem.ListItem
import code.osgroceries.domain.listitem.ListItemRepository
import code.osgroceries.domain.listitem.Unit
import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.hasSize
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.any
import org.mockito.ArgumentMatchers.anyString
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.security.InvalidParameterException
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class ListItemCreationServiceTest {

    @Rule
    @JvmField
    val expectedException: ExpectedException = ExpectedException.none()

    @InjectMocks
    lateinit var listItemCreationService: ListItemCreationService

    @Mock
    lateinit var listItemRepository: ListItemRepository

    @Mock
    lateinit var itemRepository: ItemRepository

    @Test
    fun `addListItemToList should add create a ListItem from an item and add it to the list`() {
        // given
        mockItemRepository_findById()
        mockListItemRepository_insert(mutableListOf())

        val itemId = "itemId"
        val amount = 1.5
        val unit = Unit.LTR

        // when
        val listItem = listItemCreationService.createListItem(itemId, amount, unit)

        // then
        assert.that(listItem.id, !equalTo(""))
        assert.that(listItem.itemId, equalTo(itemId))
        assert.that(listItem.unit, equalTo(unit))
        assert.that(listItem.amount, equalTo(amount))
        assert.that(listItem.fetched, equalTo(false))
    }

    @Test
    fun `addListItemToList should save ListItem in ListItemRepository`() {
        // given
        mockItemRepository_findById()

        val listItems = mutableListOf<ListItem>()
        mockListItemRepository_insert(listItems)
        mockListItemRepository_findAll(listItems)

        val itemId = "itemId"
        val amount = 3.5
        val unit = Unit.KG

        // when
        val listItem = listItemCreationService.createListItem(itemId, amount, unit)

        // then
        assert.that(listItemRepository.findAll(), hasSize(equalTo(1)))
        assert.that(listItemRepository.findAll()[0], equalTo(listItem))
    }

    @Test
    fun `addListItemToList should throw ItemNotFoundException if item with itemId doesn't exist`() {
        // given
        val itemId = "itemId"
        val amount = 3.4
        val unit = Unit.ML

        // expect
        expectedException.expect(ItemNotFoundException::class.java)

        // when
        listItemCreationService.createListItem(itemId, amount, unit)
    }

    private fun mockItemRepository_findById() {
        given(itemRepository.findById(anyString()))
                .willAnswer { Optional.of(Item(it.arguments[0] as String, "itemName")) }
    }

    private fun mockListItemRepository_insert(listItems: MutableList<ListItem>) {
        given(listItemRepository.insert(any<ListItem>())).willAnswer {
            val listItem = it.arguments[0] as ListItem

            if (listItems.add(listItem)) {
                listItem
            } else {
                null
            }
        }
    }

    private fun mockListItemRepository_findAll(listItems: MutableList<ListItem>) {
        given(listItemRepository.findAll()).willAnswer { listItems }
    }
}