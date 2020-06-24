import kotlin.test.assertEquals

/**
 * Problem 7: 10001st Prime [https://projecteuler.net/problem=7]
 *
 * Answer: Generate nth prime
 ** 6k+1, 6k-1 check
 */
fun q7(n: Int): Int {
    return nthPrime(n)
}

fun main() {
    assertEquals(q7(6), 13)
    verifyAnswer(::q7, 10001, 104743)
}