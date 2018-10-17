package code.osgroceries.domain.listitem

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ListItemMutation @Autowired constructor() : GraphQLMutationResolver