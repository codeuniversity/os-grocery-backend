package code.osgroceries.domain.supermarket.services

import code.osgroceries.GlobalConfiguration
import code.osgroceries.domain.supermarket.Supermarket
import code.osgroceries.domain.supermarket.SupermarketRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.any
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.hasSize

@RunWith(MockitoJUnitRunner::class)
class CreateDefaultSupermarketServiceTest {

    private val supermarketId: String = "supermarketId"
    private val supermarketName: String = "supermarketName"

    @InjectMocks
    lateinit var createDefaultSupermarketService: CreateDefaultSupermarketService

    @Mock
    lateinit var globalConfiguration: GlobalConfiguration

    @Mock
    lateinit var supermarketRepository: SupermarketRepository

    @Test
    fun `createDefaultSupermarket should create a supermarket with default settings`() {
        // given
        given(globalConfiguration.defaultSupermarketId).willReturn(supermarketId)
        given(globalConfiguration.defaultSupermarketName).willReturn(supermarketName)

        val supermarkets = mutableListOf<Supermarket>()
        mockSupermarketInsert(supermarkets)

        // when
        val supermarket = createDefaultSupermarketService.createDefaultSupermarket()

        // then
        assert.that(supermarket.id, equalTo(supermarketId))
        assert.that(supermarket.name, equalTo(supermarketName))
        assert.that(supermarkets, hasSize(equalTo(1)))
        assert.that(supermarkets[0], equalTo(supermarket))
    }

    private fun mockSupermarketInsert(supermarkets: MutableList<Supermarket>) {
        given(supermarketRepository.insert(any<Supermarket>())).willAnswer {
            val supermarket = it.arguments[0] as Supermarket
            if (supermarkets.add(supermarket))
                supermarket
            else
                throw Throwable()
        }
    }
}