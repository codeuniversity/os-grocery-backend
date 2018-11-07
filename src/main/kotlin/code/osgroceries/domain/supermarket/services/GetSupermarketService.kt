package code.osgroceries.domain.supermarket.services

import code.osgroceries.domain.supermarket.Supermarket
import code.osgroceries.domain.supermarket.exceptions.SupermarketNotFoundException
import org.springframework.stereotype.Service

@Service
class GetSupermarketService {

    @Throws(SupermarketNotFoundException::class)
    fun getSupermarketById(supermarketId: String): Supermarket = TODO()
}
