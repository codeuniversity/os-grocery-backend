package code.osgroceries.domain.supermarket.services

import code.osgroceries.GlobalConfiguration
import code.osgroceries.domain.supermarket.Supermarket
import code.osgroceries.domain.supermarket.SupermarketRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CreateDefaultSupermarketService @Autowired constructor(
        private val globalConfiguration: GlobalConfiguration,
        private val supermarketRepository: SupermarketRepository
) {

    fun createDefaultSupermarket(): Supermarket {
        val supermarket = Supermarket(
                globalConfiguration.defaultSupermarketId,
                globalConfiguration.defaultSupermarketName
        )
        return supermarketRepository.insert(supermarket)
    }
}