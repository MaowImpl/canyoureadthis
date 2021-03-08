private data class Word(private val string: String) {
    val start = string[0]
    val middle = string.substring(1 .. string.length - 2)
    val end = string[string.length - 1]
}

fun main(args: Array<String>) {
    if (args.size == 1) {
        val builder = StringBuilder()
        args[0].split(' ').forEach {
            var string = it
            if (it.length > 1) {
                val word = Word(it)
                string =
                    if (it.length > 3)
                        word.start + word.middle.shuffle() + word.end
                    else it
            }
            builder
                .append(string)
                .append(' ')
        }
        println(builder.toString())
    }
}

private fun String.shuffle(): String {
    return this
        .toList()
        .shuffled()
        .joinToString("")
}