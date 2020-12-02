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
    val expenses = Files.readAllLines(inputPath).map(String::toInt).toHashSet()
    for (expense in expenses) {
        val second = targetSum - expense
        if (expenses.contains(second)) {
            println("The two numbers with a sum of $targetSum multiplied together is ${expense * second}.")
            return
        }
    }
    throw IllegalArgumentException("Could not find two numbers which sum is $targetSum.")
}