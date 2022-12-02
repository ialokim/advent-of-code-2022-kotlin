abstract class Challenge(private val day: Int) {

    abstract fun part1(input: String): Int

    abstract fun part2(input: String): Int

    fun solve(p1_test: Int, p2_test: Int) {
        val dayStr = day.toString().padStart(2, '0')

        // test if implementation meets criteria from the description, like:
        val testInput = readInput("Day${dayStr}_test")
        check(part1(testInput) == p1_test)
        check(part2(testInput) == p2_test)

        val input = readInput("Day$dayStr")
        println(part1(input))
        println(part2(input))
    }
}
