package code.osgroceries.util

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.hamcrest.core.IsNot.not
import org.junit.Test

class IDGeneratorKtTest {

    @Test
    fun generateIdShouldCreate100UniqueIds() {
        // when
        val generatedIds: MutableList<String> = mutableListOf()
        for (i in 0..99)
            generatedIds.add(generateId())

        // then
        for (i in 0..99)
            for (j in (i + 1)..99)
                assertThat(generatedIds[i], not(equalTo(generatedIds[j])))
    }
}