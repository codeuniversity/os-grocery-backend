package code.osgroceries.domain.supermarket.actors

import code.osgroceries.domain.supermarket.Supermarket
import code.osgroceries.domain.supermarket.SupermarketRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class SupermarketFinder @Autowired constructor(
        private val supermarketRepository: SupermarketRepository
) {

    fun findAll(): List<Supermarket> {
        val findAll = supermarketRepository.findAll()
        return findAll.filter { it != null }
    }
}
