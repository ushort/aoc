package me.chris.aoc2020

import java.lang.IllegalArgumentException
import java.nio.file.Files
import java.nio.file.Paths

/**
 * @author Christopher
 * @since 12/2/2020
 */
fun main(args: Array<String>) {
    check(args.size == 1) { "Enter a target sum." }
    val targetSum = args[0].toInt()
    val inputPath = Paths.get(ClassLoader.getSystemResource("input1.txt").toURI())
    val expenses = Files.readAllLines(inputPath).map(String::toInt).toHashSet().sorted().toList()
    print(result(targetSum, expenses))
}

fun result(targetSum: Int, expenses: List<Int>): Int {
    for (index in expenses.indices) {
        val first = expenses[index]
        var lowIndex = index + 1
        var highIndex = expenses.size - 1
        val secondSum = targetSum - first
        while (lowIndex < highIndex) {
            val low = expenses[lowIndex]
            val high = expenses[highIndex]
            when {
                low + high == secondSum -> return first * low * high
                low + high > secondSum -> highIndex--
                else -> lowIndex++
            }
        }
    }
    throw IllegalArgumentException("Could not find three numbers whose sum is $targetSum")
}