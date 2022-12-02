object Day02: Challenge(2) {

    private fun parseInput(input: String) = input.lines().filterNot { it.isEmpty() }

    private enum class Shape {
        Rock, Paper, Scissors;

        fun score() = when (this) {
            Rock -> 1
            Paper -> 2
            Scissors -> 3
        }

        fun playAgainst(other: Shape) = when {
            this == other -> 3
            this == Rock && other == Scissors -> 6
            this == Scissors && other == Paper -> 6
            this == Paper && other == Rock -> 6
            else -> 0
        }

        companion object {
            fun parse(str: String) = when (str) {
                "A", "X" -> Rock
                "B", "Y" -> Paper
                "C", "Z" -> Scissors
                else -> error("unexpected input: $str")
            }
        }
    }

    override fun part1(input: String) = parseInput(input).sumOf { line ->
        val (elf, me) = line.split(" ").map(Shape::parse)

        me.score() + me.playAgainst(elf)
    }

    override fun part2(input: String) = parseInput(input).sumOf { line ->
        val (elfStr, outcomeStr) = line.split(" ")

        val elf = Shape.parse(elfStr)
        val me = Shape.values().first {
            it.playAgainst(elf) == when (outcomeStr) {
                "X" ->  0
                "Y" -> 3
                "Z" -> 6
                else -> error("unexpected input: $outcomeStr")
            }
        }

        me.score() + me.playAgainst(elf)
    }
}

fun main() = Day02.solve(15, 12)
