import org.junit.jupiter.api.MethodOrderer.OrderAnnotation
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.extension.ExtendWith

@TestMethodOrder(OrderAnnotation::class)
@ExtendWith(FailFastExtension::class)
abstract class BaseFailFastTest
