fun reduceNumberUntilLastPrime(number: PrimeNumber, primeNumber: Long): Long {
    var mutableNumber = number
    while (mutableNumber % primeNumber == 0L) mutableNumber /= primeNumber
    if (mutableNumber == 1L) throw LastPrimeNumberFound(primeNumber)
    return mutableNumber
}

class LastPrimeNumberFound(val primeNumber: PrimeNumber) : Throwable()

/**
 * Problem 3: Largest prime factor [https://projecteuler.net/problem=3]
 *
 * Answer: Write a fast decompose to primes function
 **  Optimisation 1: 2, 3 + step by 6 (6k-1, 6k, 6k+1, 6k+2, 6k+3, 6k+4) :: check only 6k-1, 6k+1
 **  Optimisation 2: Only need to check up until square root of N - but own't make a difference here
 */
fun q3(upperRange: Long): Int {
    var mutableNumber = upperRange

    try {
        mutableNumber = reduceNumberUntilLastPrime(mutableNumber, 2)
        mutableNumber = reduceNumberUntilLastPrime(mutableNumber, 3)
        for (primeNumber in 6L..mutableNumber step 6L) {
            mutableNumber = reduceNumberUntilLastPrime(mutableNumber, primeNumber - 1)
            mutableNumber = reduceNumberUntilLastPrime(mutableNumber, primeNumber + 1)
        }
    } catch (e: LastPrimeNumberFound) {
        return e.primeNumber.toInt()
    }

    throw Exception("Woops")
}

fun main() {
    verifyAnswer(::q3, 600851475143, 6857)
}