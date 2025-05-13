package il.pacolo.com.appweather.playgrounds.patterns

import org.junit.Test

class ComponentTest {
    @Test
    fun builderTest() {
        val component = Component.Builder()
            .setName("Fran")
            .setLastName("Martin")
            .build()
        assert(component.name == "Fran")
        assert(component.lastName == "Martin")

    }

}