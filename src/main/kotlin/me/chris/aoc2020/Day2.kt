package me.chris.aoc2020

import java.nio.file.Files
import java.nio.file.Paths

/**
 * @author Christopher
 * @since 12/3/2020
 */
fun main() {
    val inputPath = Paths.get(ClassLoader.getSystemResource("input2.txt").toURI())
    val passwords = Files.readAllLines(inputPath).toHashSet().sorted().toList()
    println(passwords.filter(::isValid).size)
}

fun isValid(policyAndPassword: String): Boolean {
    val min = policyAndPassword.substringBefore("-").toInt()
    val max = policyAndPassword.substringAfter("-").substringBefore(" ").toInt()
    val range = min..max
    val requiredCharacter = policyAndPassword.substringAfter(" ").substringBefore(":").single()
    val password = policyAndPassword.substringAfter(": ")
    return range.contains(password.filter { it == requiredCharacter }.length)
}