package code.osgroceries.domain.supermarket.services

import code.osgroceries.domain.supermarket.actors.SupermarketFinder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SupermarketGetAllService @Autowired constructor(
        private val supermarketFinder: SupermarketFinder
) {

    fun getAll() = supermarketFinder.findAll()
}
