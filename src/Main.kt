fun q1(upperRange: Int = 1000): Int {
//    val multiples3 = for (integer in 3..1000)
    val multiplesOf3 = generateSequence(3) { if (it + 3 < upperRange) it + 3 else null }
    val multiplesOf5 = generateSequence(5) { if (it + 5 < upperRange) it + 5 else null }

    val multiplesOf15 = generateSequence(15) { if (it + 15 < upperRange) it + 15 else null }

    return multiplesOf3.sum() + multiplesOf5.sum() - multiplesOf15.sum()
}

fun main() {
    assert(q1(10) == 23)
    println(q1())
}