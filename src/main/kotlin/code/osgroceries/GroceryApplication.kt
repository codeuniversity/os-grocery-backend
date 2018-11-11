package code.osgroceries

import code.osgroceries.domain.supermarket.services.CreateDefaultSupermarketService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource

@SpringBootApplication
@PropertySource(value = ["application.properties"])
class GroceryApplication

fun main(args: Array<String>) {
    val context = runApplication<GroceryApplication>(*args)

    context.getBean(CreateDefaultSupermarketService::class.java).createDefaultSupermarket()
}
