import org.junit.jupiter.api.extension.ConditionEvaluationResult
import org.junit.jupiter.api.extension.ExecutionCondition
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler
import java.util.concurrent.ConcurrentHashMap

class FailFastExtension : ExecutionCondition, TestExecutionExceptionHandler {
    companion object {
        private val failedClasses = ConcurrentHashMap.newKeySet<Class<*>>()
    }

    override fun evaluateExecutionCondition(context: ExtensionContext): ConditionEvaluationResult {
        val testClass = context.testClass.orElse(null)

        return if (testClass != null && failedClasses.contains(testClass)) {
            ConditionEvaluationResult.disabled("Skipping test because a previous test in this class failed")
        } else {
            ConditionEvaluationResult.enabled("Test execution allowed")
        }
    }

    override fun handleTestExecutionException(context: ExtensionContext, throwable: Throwable) {
        val testClass = context.testClass.orElse(null)
        if (testClass != null) {
            failedClasses.add(testClass)
            println("Test ${context.displayName} failed - marking class ${testClass.simpleName} to skip remaining tests")
        }
        throw throwable
    }
}
