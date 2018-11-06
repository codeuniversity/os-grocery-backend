package code.osgroceries.domain.listitem

data class ListItem(
        val id: String,
        val itemId: String,
        val unit: Unit,
        val amount: Double,
        val fetched: Boolean
)