private val SUFFIXES = """[.,!?:;'"]""".toRegex()

fun main(args: Array<String>) {
    if (args.size == 1) {
        val builder = StringBuilder()
        args[0].split(' ').forEach {
            var s: String? = null
            if (it.length > 3)
                s = it[0] + getMiddle(it) + getEnd(it)
            builder.append("${s ?: it} ")
        }
        println(builder.toString())
    }
}

private fun getMiddle(string: String): String {
    val index = SUFFIXES.find(string)?.range?.first
    return if (index != null)
        string.substring(1 until index - 1)
    else string.substring(1 until string.length - 1)
        .toList()
        .shuffled()
        .joinToString("")
}

private fun getEnd(string: String): String {
    val range = SUFFIXES.find(string)?.range
    return if (range != null)
        string.substring(range.first - 1, range.last + 1)
    else string.substring(string.length - 1)
}