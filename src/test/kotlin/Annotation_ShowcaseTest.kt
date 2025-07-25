import helper.FailFastTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test

@Suppress("ClassName")
@FailFastTest
class Annotation_ShowcaseTest {
    companion object {
        @BeforeAll
        @JvmStatic
        fun setup() {
            println("Setup for all tests")
        }
    }

    @Test
    @Order(1)
    fun testFirst() {
        println("First test executed")
        Assertions.assertTrue(false)
    }

    @Test
    @Order(2)
    fun testSecond() {
        println("Second test executed")
        Assertions.assertTrue(true)
    }
}
