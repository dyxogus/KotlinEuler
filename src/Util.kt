import java.lang.System.currentTimeMillis
import kotlin.math.pow
import kotlin.test.assertEquals

fun <InputType, OutputType> verifyAnswer(question: (InputType) -> OutputType, input: InputType, answer: OutputType) {
    val start = currentTimeMillis()
    assertEquals(question(input), answer)

    val end = currentTimeMillis()
    val timeTaken = end - start
    println("[${timeTaken}ms] $question: $answer")
}

/**
 * Integer power using [Double.pow]
 * Long power using [Double.pow]
 * Double power using [Double.pow]
 * Float power using [Float.pow]
 */
infix fun Int.`**`(exponent: Int): Int = toDouble().pow(exponent).toInt()
infix fun Long.`**`(exponent: Int): Long = toDouble().pow(exponent).toLong()
infix fun Float.`**`(exponent: Int): Float = this.pow(exponent)
infix fun Double.`**`(exponent: Int): Double = this.pow(exponent)
