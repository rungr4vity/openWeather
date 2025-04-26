package il.pacolo.com.appweather.playgrounds



val regex  = "\\s".toRegex()
val text = "once upon a time  there lived  a little  puppu named bruno"
fun countWords(input: String) = input.split(regex).size
fun String.wordCount(): Int  = this.split(regex).size


fun main() {

    val total1 =  countWords(text)
    val total2 = text.wordCount()

    val functionWithNoReceiver:(String) -> Int = :: countWords
    val text3 = functionWithNoReceiver(text)
}