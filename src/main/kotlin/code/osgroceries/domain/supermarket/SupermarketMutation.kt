package code.osgroceries.domain.supermarket

import code.osgroceries.util.generateId
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SupermarketMutation @Autowired constructor(
        val supermarketRepository: SupermarketRepository
) : GraphQLMutationResolver {

    fun createSupermarket(name: String) =
            supermarketRepository.insert(Supermarket(generateId(), name))
}
