package cz.training.kotlin

fun main() {
    listOf("hello", "world", "testing", "more testing")
            .filter {it.length > 5}
            .forEach { println(it) }

    //transformations
    listOf("hello", "world", "testing", "more testing")
            .map { it.uppercase() }
            .forEach { println(it) }

    listOf("hello", "world", "testing", "more testing")
            .mapIndexed { index, s ->
                "$index - $s"
            }
            .forEach { println(it) }

    listOf("hello", "world", "testing", "more testing")
            .mapNotNull {
                if (it.length <= 5)
                    null
                else
                    it.uppercase()
            }
            .forEach { println(it) }

    mapOf("hello" to "world")
            .mapKeys { it.key.uppercase() }
            .forEach { println(it) }
    mapOf("hello" to "world")
            .mapValues { it.key.uppercase() }
            .forEach { println(it) }
    listOf("hello", "world", "test", "ahoj")
            .associateWith { it.first() }
            .also { println(it) }
    listOf("hello", "world", "test", "ahoj")
            .associateBy { it.first() }
            .also { println(it) }

    listOf("hello", "hello2", "world", "test", "ahoj")
            .associateBy { it.first() }
            .also { println(it) }

    listOf("hello", "hello2", "world", "test", "ahoj")
            .groupBy { it.first() }
            .also { println(it) }

    listOf("hello", "hello2", "world", "test", "ahoj")
            .groupBy { it.first() }
            .mapValues { it.value.size }
            .also { println(it) }

    listOf("hello", "world").zip(listOf("ahoj", "svete"))
            .also { println(it) }
    listOf("hello", "world").zip(listOf("ahoj", "svete"))
            .toMap()
            .also { println(it) }

    listOf("hello" to "world", "ahoj" to "svete")
            .unzip()
            .also { println(it) }

    listOf(
            listOf("hello", "world"),
            listOf("ahoj", "svete")
    )
            .flatten()
            .also { println(it) }

    setOf(
            setOf("hello", "world", "test"),
            setOf("ahoj", "svete", "test")
    )
            .flatMap {
                it.take(1)
            }
            .also { println(it) }

    listOf("hello", "world", "test")
            .joinToString (", ")
            .also { println(it) }

    listOf("hello", "world", "test")
            .joinToString (", ") {it.uppercase()}
            .also { println(it) }

    listOf("hello", "world", "test")
            .joinToString (
                    separator = ", ",
                    prefix = "|",
                    postfix = "|",
                    limit = 2,
                    truncated = "..."
            ) {it.uppercase()}
            .also { println(it) }

    listOf("hello", "world", "testing", "more testing")
            .filterNot {it.length > 5}
            .forEach { println(it) }
    listOf("hello", "world", "testing", "more testing", null)
            .filterNotNull()
            .map { it.uppercase() }
            .forEach { println(it) }

    if (listOf("hello", "world", "testing", "more testing")
            .any { it == it.lowercase()}
    ) println("at least one element is lowercase")

    if (listOf("hello", "world", "testing", "more testing")
                    .all { it == it.lowercase()}
    ) println("all elements are lowercase")

    if (listOf("hello", "world", "testing", "more testing")
                    .none { it == it.lowercase()}
    ) println("no elements are lowercase")

    listOf("hello", "World", "testing", "More testing")
            .partition { it == it.lowercase() }
            .also { println(it) }

    val (lowercaseWords, restOfWords) = listOf("hello", "World", "testing", "More testing")
            .partition { it == it.lowercase() }

    //parts
    listOf("hello", "World", "testing", "More testing")
            .slice(setOf(0, 2))
            .also { println(it) }

    listOf("hello", "World", "testing", "More testing")
            .slice(0..3 step 2)
            .also { println(it) }

    listOf("hello", "World", "testing", "More testing")
            .takeLast(2)
            .also { println(it) }

    listOf("hello", "World", "testing", "More testing")
            .drop(2)
            .also { println(it) }

    listOf("hello", "World", "testing", "More testing")
            .dropLast(2)
            .also { println(it) }

    listOf(1,2,4,8,16,8,4,2,1)
            .dropWhile { it < 8 } //[8, 16, 8, 4, 2, 1]
            .also { println(it) }
    listOf(1,2,4,8,16,8,4,2,1)
            .dropLastWhile { it < 8 } //[1, 2, 4, 8, 16, 8]
            .also { println(it) }

    listOf(1,2,4,8,16,8,4,2,1)
            .takeWhile { it < 8 } //[1, 2, 4]
            .also { println(it) }
    listOf(1,2,4,8,16,8,4,2,1)
            .takeLastWhile { it < 8 } //[4, 2, 1]
            .also { println(it) }

    listOf(1,2,4,8,16,8,4,2,1)
            .chunked(4) //[[1, 2, 4, 8], [16, 8, 4, 2], [1]]
            .also { println(it) }

    listOf(1,2,4,8,16,8,4,2,1)
            .windowed(4) //[[1, 2, 4, 8], [2, 4, 8, 16], [4, 8, 16, 8], [8, 16, 8, 4], [16, 8, 4, 2], [8, 4, 2, 1]]
            .also { println(it) }
    listOf(1,2,4,8,16,8,4,2,1)
            .windowed(4, step = 2) //[[1, 2, 4, 8], [4, 8, 16, 8], [16, 8, 4, 2]]
            .also { println(it) }
    listOf(1,2,4,8,16,8,4,2,1)
            .windowed(4, step = 3, partialWindows = true) //[[1, 2, 4, 8], [8, 16, 8, 4], [4, 2, 1]]
            .also { println(it) }

    //single element drops
    listOf(1,2,4,8,16)
            .first {it % 4 == 0} //4
            .also { println(it) }
    listOf(1,2,4,8,16)
            .last {it % 4 == 0} //16
            .also { println(it) }
    listOf(1,2,4,8,16)
            .firstOrNull {it % 32 == 0} //null
            .also { println(it) }
    listOf(1,2,4,8,16)
            .lastOrNull {it % 32 == 0} //null
            .also { println(it) }

    listOf(1,2,4,8,16)
            .random()
            .also { println(it) }
    listOf(1,2,4,8,16)
            .randomOrNull()
            .also { println(it) }

    listOf(32,1,2,4,8,16)
            .sorted() //[1, 2, 4, 8, 16, 32]
            .also { println(it) }
    listOf(32,1,2,4,8,16)
            .sortedDescending() //[32, 16, 8, 4, 2, 1]
            .also { println(it) }

    listOf(32,1,2,4,8,16)
            .sortedWith(object : Comparator<Int> {
                override fun compare(p0: Int, p1: Int): Int {
                    if (p0 == p1)
                        return p0
                    return if (p0 < p1)
                        -1
                    else
                        1
                }
            })
            .also { println(it) }

    listOf(
            Person("John", "Doe"),
            Person("Anna", "Doe"),
            Person("John", "Woe"),
            Person("John", "Woe")
    )
            .sortedWith(compareBy<Person> {it.lastName}.thenBy { it.firstName })
            .also { println(it) }

    listOf(1,2,4,8,16,8,4,2,1)
            .minOrNull()
            .also { println(it) }
    listOf(1,2,4,8,16,8,4,2,1)
            .maxOrNull()
            .also { println(it) }
    listOf(1,2,4,8,16,8,4,2,1)
            .average()
            .also { println(it) }
    listOf(1,2,4,8,16,8,4,2,1)
            .sum()
            .also { println(it) }

    listOf("hello", "World", "testing", "More testing")
            .minByOrNull { it.length }
            .also { println(it) }
    listOf("hello", "World", "testing", "More testing")
            .maxByOrNull { it.length }
            .also { println(it) }

    listOf(1,2,4,8,16,8,4,2,1)
            .reduce {acc, i -> acc+i} //46
            .also { println(it) }
    listOf(1,2,4,8,16,8,4,2,1)
            .fold(0) {acc, i -> acc+i} //46
            .also { println(it) }
}