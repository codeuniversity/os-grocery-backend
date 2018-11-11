package code.osgroceries

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

@Component
@PropertySource("classpath:global.properties")
data class GlobalConfiguration @Autowired constructor(
        @Value("\${defaults.supermarketId}") val defaultSupermarketId: String,
        @Value("\${defaults.supermarketName}") val defaultSupermarketName: String
)