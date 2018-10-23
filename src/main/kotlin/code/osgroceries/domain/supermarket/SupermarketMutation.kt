package code.osgroceries.domain.supermarket

import code.osgroceries.util.generateId
import org.springframework.beans.factory.annotation.Autowired

class SupermarketMutation @Autowired constructor(val supermarketRepository: SupermarketRepository) {

    fun createSupermarket(name: String) =
            supermarketRepository.insert(Supermarket(generateId(), name))
}