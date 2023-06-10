fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    println("*".repeat(a).plus("\n").repeat(b))
}