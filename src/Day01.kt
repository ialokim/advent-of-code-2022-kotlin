object Day01: Challenge(1) {

    private fun parseInput(input: String) = input.split("\n\n").map { it.trim().lines().sumOf { it.toInt() } }

    override fun part1(input: String) = parseInput(input).maxOf { it }

    override fun part2(input: String) = parseInput(input).sortedDescending().take(3).sum()
}

fun main() = Day01.solve(24000, 45000)
