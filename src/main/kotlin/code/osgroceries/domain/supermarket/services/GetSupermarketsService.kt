package code.osgroceries.domain.supermarket.services

import code.osgroceries.domain.supermarket.Supermarket
import code.osgroceries.domain.supermarket.SupermarketRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GetSupermarketsService @Autowired constructor(
        private val supermarketRepository: SupermarketRepository
) {

    fun getSupermarkets(): List<Supermarket> = supermarketRepository.findAll()
}