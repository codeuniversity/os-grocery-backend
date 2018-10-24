package code.osgroceries.domain.supermarket.services

import code.osgroceries.domain.supermarket.Supermarket
import code.osgroceries.domain.supermarket.actors.SupermarketCreator
import code.osgroceries.util.generateId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SupermarketCreateService @Autowired constructor(
        private val supermarketCreator: SupermarketCreator
) {

    fun create(name: String): Supermarket {
        val id = generateId()
        return supermarketCreator.createSupermarket(id, name)
    }
}