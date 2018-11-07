package code.osgroceries.domain.row.services

import code.osgroceries.domain.item.Item
import code.osgroceries.domain.item.createMockItem
import code.osgroceries.domain.item.exceptions.ItemNotFoundException
import code.osgroceries.domain.item.services.GetItemService
import code.osgroceries.domain.row.Row
import code.osgroceries.domain.row.RowRepository
import code.osgroceries.domain.row.exceptions.RowNotFoundException
import code.osgroceries.domain.row.supermarketitem.SupermarketItem
import code.osgroceries.domain.row.supermarketitem.SupermarketToItemRepository
import code.osgroceries.domain.supermarket.Supermarket
import code.osgroceries.domain.supermarket.createMockSupermarket
import code.osgroceries.domain.supermarket.exceptions.ItemNotInSupermarketException
import code.osgroceries.domain.supermarket.exceptions.SupermarketNotFoundException
import code.osgroceries.domain.supermarket.services.GetSupermarketService
import code.osgroceries.util.generateId
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
class GetRowServiceTest {

    private val rowId = "rowId"
    private val itemId = "itemId"
    private val supermarketId = "supermarketId"

    @Rule
    @JvmField
    var expectedException: ExpectedException = ExpectedException.none()

    @InjectMocks
    lateinit var getRowService: GetRowService

    @Mock
    lateinit var getItemService: GetItemService

    @Mock
    lateinit var getSupermarketService: GetSupermarketService

    @Mock
    lateinit var supermarketToItemRepository: SupermarketToItemRepository

    @Mock
    lateinit var rowRepository: RowRepository

    @Test
    fun `getRowByItemIdAndSupermarketId should throw ItemNotFoundException`() {
        // given
        given(getItemService.getItemById(itemId)).willThrow(ItemNotFoundException::class.java)

        // expect
        expectedException.expect(ItemNotFoundException::class.java)

        // when
        getRowService.getRowByItemIdAndSupermarketId(itemId, supermarketId)
    }

    @Test
    fun `getRowByItemIdAndSupermarketId should throw SupermarketNotFoundException`() {
        // given
        given(getItemService.getItemById(itemId)).willReturn(createMockItem())
        given(getSupermarketService.getSupermarketById(supermarketId))
                .willThrow(SupermarketNotFoundException::class.java)

        // expect
        expectedException.expect(SupermarketNotFoundException::class.java)

        // when
        getRowService.getRowByItemIdAndSupermarketId(itemId, supermarketId)
    }

    @Test
    fun `getRowByItemIdAndSupermarketId should throw ItemNotInSupermarketException`() {
        // given
        given(getItemService.getItemById(itemId)).willReturn(createMockItem())
        given(getSupermarketService.getSupermarketById(supermarketId)).willReturn(createMockSupermarket())
        given(supermarketToItemRepository.findBySupermarketIdAndItemId(supermarketId, itemId)).willReturn(Optional.empty())

        // expect
        expectedException.expect(ItemNotInSupermarketException::class.java)

        // when
        getRowService.getRowByItemIdAndSupermarketId(itemId, supermarketId)
    }

    @Test
    fun `getRowByItemIdAndSupermarketId should give back the correct row`() {
        // given
        given(getItemService.getItemById(itemId)).willReturn(Item(itemId, "itemName"))
        given(getSupermarketService.getSupermarketById(supermarketId)).willReturn(Supermarket(supermarketId, "supermarketName"))

        val supermarketItem = SupermarketItem(generateId(), supermarketId, itemId, rowId)
        given(supermarketToItemRepository.findBySupermarketIdAndItemId(supermarketId, itemId))
                .willReturn(Optional.of(supermarketItem))

        val expectedRow = Row(rowId, "rowName", "supermarketId")
        given(rowRepository.findById(rowId)).willReturn(Optional.of(expectedRow))

        // when
        val row = getRowService.getRowByItemIdAndSupermarketId(itemId, supermarketId)

        // then
        assert.that(row, equalTo(expectedRow))
    }

    @Test
    fun `getRowById should throw RowNotFoundException`() {
        // given
        given(rowRepository.findById(rowId)).willReturn(Optional.empty())

        // expect
        expectedException.expect(RowNotFoundException::class.java)

        // when
        getRowService.getRowById(rowId)
    }

    @Test
    fun `getRowById should get the row by its id`() {
        // given
        val expectedRow = Row(rowId, "rowName", "supermarketId")
        given(rowRepository.findById(rowId)).willReturn(Optional.of(expectedRow))

        // when
        val row = getRowService.getRowById(rowId)

        // then
        assert.that(row, equalTo(expectedRow))
    }
}