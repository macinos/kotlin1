package cz.training.kotlin

import java.time.LocalDate

open class Person1(
        var firstName: String,
        var lastName: String,
        var dateOfBirth: LocalDate
) {
    val age: Int
        get() = LocalDate.now().year - dateOfBirth.year

    open fun sayHello() =
            println("Hello $firstName $lastName")
}

class Employee1(
        firstName: String,
        lastName: String,
        dateOfBirth: LocalDate,
        var jobTitle: String
) : Person1(firstName, lastName, dateOfBirth) {
    override fun sayHello() {
        super.sayHello()
        println("also hello from $jobTitle")
    }
}

fun main(args: Array<String>) {
    val p1 = Person1("John", "Doe", LocalDate.of(2000, 1, 1))
    println(p1.firstName)
    println(p1.lastName)

    p1.firstName = "Johnny"
    println(p1.firstName)
    println(p1.age)

    val e1 = Employee1(
        firstName = "John",
        lastName = "Doe",
        dateOfBirth = LocalDate.of(2000, 1, 1),
        jobTitle = "Tester"
    )
    println(e1.jobTitle)
    println(e1.firstName)

    class Person2(
            val firstName: String, //nyni s val ne s var
            val lastName: String
    ){
        val lastNameUpperCase: String =
                lastName.uppercase()

        //sekundarni konstruktor, neni to prilis typicke delat takto kontruktory v Kotlinu
        constructor() : this(firstName = "John", lastName = "Doe")

        init {
            println("Hello, $firstName and $lastName")
        }
        init {
            println("Hello again, $firstName and $lastName")
        }
    }

    /*
        Pro injection
    class MyService {
        @Inject
        private lateinit var myDependency: MyDependency
    }
     */

    println(Person2(firstName = "test", lastName = "johnny")
            .lastNameUpperCase)
    println(Person2().lastName)

    /*val person4 = Person(
            firstName = "John",
            lastName = "Doe"
    )
    if (person4 == Person(
                    firstName = "John",
                    lastName = "Doe"
            )) {
        println("person4 equals")
        println(person4)
    }
    println(person4.copy(firstName = "Johny"))

    val (firstName, lastName) = person4 //vyzobe si to stejne pojmenovane promenne a priradi novym promennym
    println(firstName)*/
}