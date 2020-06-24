import kotlin.math.pow
import kotlin.test.assertEquals

val MILLION = 10.toDouble().pow(6).toInt()

/**
 * Problem 2: Even Fibonacci numbers [https://projecteuler.net/problem=2]
 *
 * Answer:
 ** Every third fibonnaci sequence is an even-valued number
 *** [1st]1, [2nd]1, [3rd]2 => [1st]odd, [2nd]odd, [3rd]even
 **** [4th] is odd  because [4th] = [2nd]odd  + [3rd]even
 **** [5th] is odd  because [5th] = [3rd]even + [4th]odd
 **** [6th] is even because [6th] = [4th]odd  + [5th]odd
 *** sequence repeats for [i]odd, [i+1]odd, [i+2] even
 */
fun q2(limit: Int = 4 * MILLION): Int {
    var sum = 0
    var (second, third) = arrayOf(1, 2)

    while (third < limit) {
        sum += third

        val first = second + third
        second = first + third
        third = first + second
//        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.FINEST, "$first, $second, $third, ")
    }

    return sum
}

fun main() {
    assertEquals(q2(2), 0)
    assertEquals(q2(2 + 1), 2)
    assertEquals(q2(34 + 1), 44)

    verifyAnswer(::q2, 4 * MILLION, 4613732)
//    Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).level = Level.FINEST
//    Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).addHandler(StreamHandler(System.out, SimpleFormatter()))
}