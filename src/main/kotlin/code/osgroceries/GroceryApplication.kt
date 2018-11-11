package code.osgroceries

import code.osgroceries.domain.item.services.CreateItemService
import code.osgroceries.domain.row.Row
import code.osgroceries.domain.row.services.CreateRowService
import code.osgroceries.domain.supermarket.services.CreateDefaultSupermarketService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

@SpringBootApplication
@PropertySource(value = ["application.properties"])
class GroceryApplication

fun main(args: Array<String>) {
    val context = runApplication<GroceryApplication>(*args)

    context.getBean(CreateDefaultSupermarketService::class.java).createDefaultSupermarket()

    context.getBean(DefaultRowAndItemCreator::class.java).insertDefaults()
}

@Component
class DefaultRowAndItemCreator @Autowired constructor(
        private val globalConfiguration: GlobalConfiguration,
        private val createRowService: CreateRowService,
        private val createItemService: CreateItemService
) {

    fun insertDefaults() {
        val rowsAsStrings = globalConfiguration.defaultDataAsString.split('|')
        rowsAsStrings.forEach { rowAsString ->
            val (rowName, itemsInRow) = rowAsString.split(':')
            val row: Row = createRowService.createRow(rowName, globalConfiguration.defaultSupermarketId)

            itemsInRow.split(',').forEach { itemAsString ->
                createItemService.createItemAndMapToRow(itemAsString, row.id)
            }
        }
    }
}
