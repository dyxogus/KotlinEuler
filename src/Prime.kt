typealias PrimeNumber = Long

fun decomposeToPrimePowers(number: Int, primeNumbers: List<Int>): Map<Int, Int> {
    var mutableNumber = number
    val primePowers = HashMap<Int, Int>()

    for (primeNumber in primeNumbers) {
        while (mutableNumber % primeNumber == 0) {
            primePowers[primeNumber] = primePowers.getOrDefault(primeNumber, 0) + 1
            mutableNumber /= primeNumber
        }

        if (mutableNumber == 1) return primePowers
    }

    throw Exception("Not enough prime numbers provided")
}

fun generatePrimeNumbers(upperRange: Int): ArrayList<Int> {
    assert(upperRange > 2)

    val isPrimeList = BooleanArray(3) { false } + BooleanArray(upperRange - 2) { it % 2 == 0 }
    val primeNumbers = arrayListOf(2)

    for ((primeNumber, isPrime) in isPrimeList.withIndex()) {
        if (isPrime) {
            primeNumbers.add(primeNumber)

            for (index in (2..upperRange / primeNumber))
                isPrimeList[index * primeNumber] = false
        }
    }

    return primeNumbers
}