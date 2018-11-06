package code.osgroceries.domain.exceptions

abstract class NotFoundException(
        override val message: String
) : Throwable(message)