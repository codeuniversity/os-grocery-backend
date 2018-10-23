package code.osgroceries.domain.supermarket

import org.springframework.beans.factory.annotation.Autowired

class SupermarketQuery @Autowired constructor(val supermarketRepository: SupermarketRepository) {

    fun getAllSupermarkets() = supermarketRepository.findAll()
}