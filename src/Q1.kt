fun sumOfMultiplesUnderComplicated(multiple: Int, upperRange: Int): Int {
    return generateSequence(multiple) { if (it + multiple < upperRange) it + multiple else null }.sum()
}

fun sumOfMultiplesUnder(multiple: Int, upperRange: Int): Int {
    return (multiple..upperRange step multiple).sum()
}

fun q1(upperRange: Int = 1000): Int {
    val sumOfMultipleOf3 = sumOfMultiplesUnder(3, upperRange)
    val sumOfMultipleOf5 = sumOfMultiplesUnder(5, upperRange)
    val sumOfMultipleOf15 = sumOfMultiplesUnder(15, upperRange)

    return sumOfMultipleOf3 + sumOfMultipleOf5 - sumOfMultipleOf15
}

fun main() {
    assert(q1(10) == 23)
    assert(q1() == 233168)
}