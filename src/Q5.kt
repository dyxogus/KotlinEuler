import kotlin.math.max
import kotlin.math.pow
import kotlin.test.assertEquals

/**
 * Problem 5: Smallest Multiple [https://projecteuler.net/problem=5]
 *
 * Answer: Decompose to prime powers (from 1 - N) and find the highest prime power needed for each prime number
 */
fun q5(upperRange: Int): Int {
    val primeNumbers = generatePrimeNumbers(upperRange)
    var mergedPrimePowers = mapOf(2 to 1)

    for (number in 3..upperRange) {
        val primePowers = decomposeToPrimePowers(number, primeNumbers)
        mergedPrimePowers = (mergedPrimePowers.keys + primePowers.keys).associateWith {
            max(mergedPrimePowers.getOrDefault(it, 0), primePowers.getOrDefault(it, 0))
        }
    }

    return mergedPrimePowers.keys.fold(
        1,
        { accumulated, primeNumber ->
            accumulated * (primeNumber.toDouble().pow(mergedPrimePowers.getValue(primeNumber)).toInt())
        })
}


fun main() {
    assertEquals(q5(10), 2520)
    verifyAnswer(::q5, 20, 232792560)
}