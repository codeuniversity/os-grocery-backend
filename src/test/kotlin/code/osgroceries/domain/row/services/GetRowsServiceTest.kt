package code.osgroceries.domain.row.services

import code.osgroceries.domain.row.Row
import code.osgroceries.domain.row.RowRepository
import code.osgroceries.util.generateId
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
class GetRowsServiceTest {

    private val supermarketId: String = "supermarketId"

    @InjectMocks
    lateinit var getRowsService: GetRowsService

    @Mock
    lateinit var rowRepository: RowRepository

    @Test
    fun `getRowsBySupermarketId should get all rows for supermarket with given id`() {
        // given
        val givenRows = listOf(
                Row(generateId(), "Row 1", supermarketId),
                Row(generateId(), "Row 2", supermarketId)
        )
        given(rowRepository.findBySupermarketId(supermarketId)).willReturn(givenRows)

        // when
        val rows = getRowsService.getRowsBySupermarketId(supermarketId)

        // then
        assert.that(rows, hasSize(equalTo(2)))
        assert.that(rows[0], equalTo(givenRows[0]))
        assert.that(rows[1], equalTo(givenRows[1]))
    }
}