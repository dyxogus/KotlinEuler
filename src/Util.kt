import java.lang.System.currentTimeMillis
import kotlin.test.assertEquals

fun <InputType, OutputType> verifyAnswer(question: (InputType) -> OutputType, input: InputType, answer: OutputType) {
    val start = currentTimeMillis()
    assertEquals(question(input), answer)

    val end = currentTimeMillis()
    val timeTaken = end - start
    println("[${timeTaken}ms] $question: $answer")
}