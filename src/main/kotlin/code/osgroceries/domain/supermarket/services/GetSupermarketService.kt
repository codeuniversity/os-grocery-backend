package code.osgroceries.domain.supermarket.services

import code.osgroceries.domain.supermarket.Supermarket
import code.osgroceries.domain.supermarket.SupermarketRepository
import code.osgroceries.domain.supermarket.exceptions.SupermarketNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GetSupermarketService @Autowired constructor(
        private val supermarketRepository: SupermarketRepository
) {

    @Throws(SupermarketNotFoundException::class)
    fun getSupermarketById(supermarketId: String): Supermarket {
        val optionalSupermarket = supermarketRepository.findById(supermarketId)

        if (!optionalSupermarket.isPresent)
            throw SupermarketNotFoundException("Supermarket with id $supermarketId not found.")

        return optionalSupermarket.get()
    }
}
