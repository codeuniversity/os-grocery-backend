package code.osgroceries.domain.listitem

data class ListItem(
        val id: String,
        val unit: Unit,
        val amount: Float,
        val fetched: Boolean
)