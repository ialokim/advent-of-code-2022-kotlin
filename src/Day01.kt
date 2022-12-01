fun parseInput(input: String) = input.split("\n\n").map { it.trim().lines().sumOf { it.toInt() } }

fun main() {
    fun part1(input: String) = parseInput(input).maxOf { it }

    fun part2(input: String) = parseInput(input).sortedDescending().take(3).sum()

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
