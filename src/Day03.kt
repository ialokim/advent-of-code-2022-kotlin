object Day03: Challenge(3) {

    private fun parseInput(input: String) = input.lines().filterNot { it.isEmpty() }

    override fun part1(input: String) = parseInput(input).sumOf { line ->
        val c1 = line.take(line.length/2)
        val c2 = line.takeLast(line.length/2)

        val item = c1.find { c2.contains(it) } ?: error("WTF")
        if (item.isLowerCase()) (item - 'a') + 1
        else (item - 'A') + 27
    }

    override fun part2(input: String) = parseInput(input).chunked(3).sumOf { group ->
        val item = group[0].find { group[1].contains(it) && group[2].contains(it) } ?: error("WTF")
        if (item.isLowerCase()) (item - 'a') + 1
        else (item - 'A') + 27
    }
}

fun main() = Day03.solve(157, 70)
