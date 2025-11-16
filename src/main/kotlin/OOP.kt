package org.example

open class Software(val name: String){
    fun release(){
        println("Deploying $name")
    }

    override fun toString(): String {
        return "Software(name='$name')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Software) return false

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }


}

class MobileApp(name: String): Software(name)

data class SoftwareEngineer(
    val name: String,
    val age: Int,
    val expertise : String
)

object Singleton{
    fun saySomething(){
        println("Hello from Singleton")
    }
}

abstract class ComputerPart(val name: String){
    fun assemble(){
        println("Assembling $name")
    }

    override fun toString(): String {
        return "ComputerPart(name='$name')"
    }

}

class CPU(name : String): ComputerPart(name)
class GPU(name : String): ComputerPart(name)

// Sealed class
sealed class OS(val name: String){
    class Linux(name : String): OS(name)
    class Windows(name : String): OS(name)
    class Mac(name : String): OS(name)
}

interface MovieApiService{
    fun getAllMovies(): List<String>
    fun getSingleMovie(movieId: Int): String
}

class MovieApiServiceImpl: MovieApiService{
    override fun getAllMovies(): List<String> {
        return listOf("Movie1", "Movie2", "Movie3")
    }

    override fun getSingleMovie(movieId: Int): String {
        return "Movie$movieId"
    }

    fun doSomething(){
        println("Doing something")
    }

}

class Company{
    val name: String
    val employees: Int
    constructor(name: String, employees: Int,){
        this.name = name
        this.employees = employees
    }

    override fun toString(): String {
        return "Company(name='$name', employees=$employees)"
    }


}

fun main(){
    val software = Software("ChatGPT")
    println(software)
    software.release()

    val x = MobileApp("X")
    x.release()
    println(x)

    val facebook = MobileApp("Facebook")
    println(x == facebook)

    val x2 = MobileApp("X")
    println(x == x2)

    val se1 = SoftwareEngineer(name = "John", age = 30, expertise = "Kotlin")
    val se2 = SoftwareEngineer(name = "John", age = 30, expertise = "Kotlin")
    println(se1)
    println(se1 == se2)

    val se1Copy = se1.copy(
        name = "Jack"
    )
    println(se1Copy)

    val initialState = HomeScreenState()
    val loadingState = initialState.copy(isLoading = true)
    val errorState = initialState.copy(isLoading = false, error = "Network Error")
    val dataState = initialState.copy(movies = listOf("Movie1", "Movie2"), isLoading = false)

    val company = Company(name = "Tech Corp", employees = 500)
    println(company)

    println(Singleton.saySomething())

    val  cpu = CPU(name = "Ryzen 9 9800x3d")
    println(cpu)
    cpu.assemble()

    val gpu = GPU(name = "NVIDIA RTX 5090")
    println(gpu)
    gpu.assemble()

    val ryzen55600 : ComputerPart = CPU("Ryzen 5 5600")
    when (ryzen55600) {
        is CPU -> println("It's a CPU")
        is GPU -> println("It's a GPU")
        else -> println("Unknown Computer Part")
    }

    val movieApiService : MovieApiService = MovieApiServiceImpl()

    println(movieApiService.getAllMovies())
    println(movieApiService.getSingleMovie(1))


    val  windows11 : OS = OS.Windows(name = "Windows11")
    when(windows11){
        is OS.Linux -> {
            println("This is Linux")
        }
        is OS.Mac -> {
            println("This is Mac")
        }
        is OS.Windows -> {
            println("This is Windows")
        }
    }


}


data class HomeScreenState(
   val movies : List<String> = listOf(),
    val isLoading: Boolean = false,
    val error : String = ""
)


sealed class  Actions{
    data class OnEmailChange(val email: String): Actions()
    data class OnPasswordChange(val password: String): Actions()
    class OnLoginTapped() : Actions()
    class OnRegisterTapped() : Actions()
}

