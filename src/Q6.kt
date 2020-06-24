import kotlin.test.assertEquals

/**
 * Problem 6: Sum square difference [https://projecteuler.net/problem=6]
 *
 * Answer:
 * B1: Practice using range + map
 * B2: Use Simplification
 *   - Sigma(n^2) => (2n^3 + 3n^2 + n) / 6
 *   - Sigma(n) => (n*(n+1))/2
 */
fun q6(n: Int): Int {
//    val sumOfSquares = (1..upperRange).map { it `**` 2 }.sum()
//    val sumSquared = (1..upperRange).sum() `**` 2

    val sumOfSquares = (2 * (n `**` 3) + 3 * (n `**` 2) + n) / 6
    val sumSquared = ((n * (n + 1)) / 2) `**` 2

    return sumSquared - sumOfSquares
}

fun main() {
    assertEquals(q6(10), 2640)
    verifyAnswer(::q6, 100, 25164150)
}