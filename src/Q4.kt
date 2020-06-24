import kotlin.math.pow
import kotlin.test.assertEquals

/**
 * Problem 4: Largest Palindrome Product [https://projecteuler.net/problem=4]
 *
 * Answer: Implement a isPalindrome function
 */
fun q4(digit: Int): Int {
    val upper = 10f.pow(digit).toInt()
    val lower = 10f.pow(digit - 1).toInt() * 9

    var largestProduct = -1

    for (i in upper - 1 downTo lower) {
        for (j in upper - 1 downTo lower) {
            val product = i * j
            if (isPalindrome(product)) largestProduct = largestProduct.coerceAtLeast(product)
        }
    }
    return largestProduct
}

fun isPalindrome(product: Int): Boolean {
    val numberString = product.toString()
    return numberString == numberString.reversed()
}

fun main() {
    assertEquals(q4(2), 9009)

    verifyAnswer(::q4, 3, 906609)
}