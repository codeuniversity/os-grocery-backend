package code.osgroceries.domain.supermarket.services

import code.osgroceries.domain.supermarket.Supermarket
import code.osgroceries.domain.supermarket.SupermarketRepository
import code.osgroceries.domain.supermarket.exceptions.SupermarketNotFoundException
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
class GetSupermarketServiceTest {

    private val supermarketId: String = "supermarketId"

    @Rule
    @JvmField
    var expectedException: ExpectedException = ExpectedException.none()

    @InjectMocks
    lateinit var getSupermarketService: GetSupermarketService

    @Mock
    lateinit var supermarketRepository: SupermarketRepository

    @Test
    fun `getSupermarketById should throw SupermarketNotFoundException`() {
        // given
        given(supermarketRepository.findById(supermarketId)).willReturn(Optional.empty())

        // expect
        expectedException.expect(SupermarketNotFoundException::class.java)

        // when
        getSupermarketService.getSupermarketById(supermarketId)
    }

    @Test
    fun `getSupermarketById should get Supermarket by id`() {
        // given
        val expectedSupermarket = Supermarket(supermarketId, "supermarketName")
        given(supermarketRepository.findById(supermarketId)).willReturn(Optional.of(expectedSupermarket))

        // when
        val supermarket = getSupermarketService.getSupermarketById(supermarketId)

        // then
        assert.that(supermarket, equalTo(expectedSupermarket))
    }
}