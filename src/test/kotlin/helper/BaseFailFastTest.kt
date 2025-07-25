package helper

import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.extension.ExtendWith

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@ExtendWith(FailFastExtension::class)
abstract class BaseFailFastTest
