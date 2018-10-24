package code.osgroceries.domain.supermarket.actors

import code.osgroceries.domain.supermarket.Supermarket
import code.osgroceries.domain.supermarket.SupermarketRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class SupermarketCreator @Autowired constructor(
        private val supermarketRepository: SupermarketRepository
) {

    fun createSupermarket(id: String, name: String) =
            supermarketRepository.insert(Supermarket(id, name))
}
