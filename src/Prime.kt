typealias PrimeNumber = Long
typealias PrimeFactor = Int

fun decomposeToPrimeFactors(number: Long): Map<PrimeNumber, PrimeFactor> {
    var numberDecomposed = number
    val primeFactors = mutableMapOf<PrimeNumber, PrimeFactor>()

    for (primeNumber in (2L..4L) + (6L..number step 1L)) {
        while (numberDecomposed % primeNumber == 0L) {
            numberDecomposed /= primeNumber
            primeFactors[primeNumber] = primeFactors[primeNumber] ?: 1
        }

        if (numberDecomposed == 1L)
            return primeFactors
    }

    return primeFactors
}
