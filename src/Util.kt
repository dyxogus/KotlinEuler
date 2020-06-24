import kotlin.test.assertEquals

fun <InputType, OutputType> verifyAnswer(question: (InputType) -> OutputType, input: InputType, answer: OutputType) {
    assertEquals(question(input), answer)
    println("$question: $answer")
}