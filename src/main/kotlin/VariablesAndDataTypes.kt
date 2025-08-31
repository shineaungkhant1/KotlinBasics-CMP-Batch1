package org.example

const val MARGON_MEDIUM = 8

fun main(){
    val firstByte : Byte = 127
    val firstShort : Short = 3232
    val firstInt : Int = 12342312
    val firstLong : Long = 12312312L
    val firstChar : Char = 'a'
    val firstFloat : Float = 23.0f
    val firstDouble : Double = 23.0
    val firstString : String = "Hello"


    println("Byte: $firstByte\nShort: $firstShort\nInt: $firstInt\nLong: $firstLong\nChar: $firstChar\nFloat: $firstFloat\nDouble: $firstDouble\nString: $firstString")

    // Type Inference
    val secondString = "Hello"
    val secondInt = 32
    println(secondString::class.java)
    println(secondInt::class.java)

    // var,val
    var thirdInt = 32
    thirdInt = 64

    val  thirdString = "mew string"
    // thirdString = "new string"

    // Optional
    val fifth : Int = 2323
    var fourth : Int?

    println(MARGON_MEDIUM)


}
