package code.osgroceries.domain.item.services

import code.osgroceries.domain.item.Item
import code.osgroceries.domain.item.exceptions.ItemNotFoundException
import org.springframework.stereotype.Service

@Service
class GetItemService {

    @Throws(ItemNotFoundException::class)
    fun getItemById(itemId: String): Item = TODO()
}
