package cz.training.kotlin

fun main() {
    val list1 = listOf("Hello", "World")
    println(list1.let {
        println("hello - $it") //it je implicitni nazev promenne kdyz ji nedefinujeme v lambde
        it.size //navratova hodnota lambdy je posledni prikaz
    })

    val list2: List<String>? = listOf("Hello", "World")
    println(list2
            ?.let {
                if (it.size >= 2)
                    it[1]
                else
                    null
            } ?: "Not found" //?: pokud je prvni operator null, vrati se druhy
    )

    //run vraci vysledek lambdy
    println(list1.run {
        println("hello - $size")
        size
    })
    val list4 = mutableListOf<String>()
    list4.run {
        add("hello")
        add("list")
    }
    println(list4)

    run {
        println("hello worlde!")
    }
    println(list2?.size ?: run {
        println("Warning: Using default value for list size")
        2
    })

    //apply se zavola na object, ale nevraci vysledek a vraci kontext objekt
    println(
            list4.apply {
                add("1")
                add("2")
            }
    )
    /*
    val p = PersonJava()
    p.firstName = "John"
    p.lastName = "Doe"
     */
    val p = PersonJava().apply {
        firstName = "John"
        lastName = "Doe"
    }

    //zavolano po provedeni
    val p2 = Person(firstName = "John", lastName = "Doe")
            .also {
                println("Created person $it")
            }
    println(p2)
}
