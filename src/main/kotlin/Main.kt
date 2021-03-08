private val SUFFIXES = """[.,!?:;'"]""".toRegex()

private data class Word(private val string: String) {
    val start = string[0]
    val middle = getMiddle(string)
    val end = getEnd(string)

    private fun getMiddle(string: String): String {
        val index = SUFFIXES.find(string)?.range?.first
        return if (index != null)
            string.substring(1 until index - 1)
        else string.substring(1 until string.length - 1)
    }

    private fun getEnd(string: String): String {
        val range = SUFFIXES.find(string)?.range
        return if (range != null)
            string.substring(range.first - 1, range.last + 1)
        else string.substring(string.length - 1)
    }
}

fun main(args: Array<String>) {
    if (args.size == 1) {
        val builder = StringBuilder()
        args[0].split(' ').forEach {
            var string = it
            if (it.length > 3) {
                val word = Word(it)
                string = word.start + word.middle.shuffle() + word.end
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