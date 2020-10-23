fun main() {

    //a
    val ranges = 1.rangeTo(10) step 3
    for (i in ranges ){
        println("value is $i!")
    }
    println()
    //b
    val rangesb = 1.rangeTo(10) step 3
    for ((index, value) in rangesb.withIndex()) {
        println("value $value with index $index")
    } // test
}