import java.util.*
import kotlin.random.Random
import Combatant
fun main() {
    val input=Scanner(System.`in`)
    val characters = mutableListOf<Human>()
    val numberOfCharacters = 3
    repeat(numberOfCharacters) {
        println("Введите тип персонажа (wizard, robot, knight):")
        val type = input.next()
        println("Введите значения здоровья, силы, атаки через пробел:")
        val health=input.nextInt()
        val power=input.nextInt()
        val attack=input.nextInt()
        characters.add(CharacterFactory.createCharacter(type, health, power, attack))
    }
    while (true) {
        characters.forEach { it.displayStatus() }
        println("Введите команду атаки:")
        var a=input.nextInt()
        var b=input.nextInt()
        if (a == b) {
            println("Атакующий и защищающийся не могут быть одним и тем же персонажем.")
            continue
        }
        val attacker = characters[a - 1]
        val defender = characters[b - 1]
        attacker.attack(defender)
        if (!defender.isAlive()) {
            println("${defender.javaClass.simpleName} побежден")
            break
        }
        if (Random.nextInt(0,100)<30) {
            characters.forEach { it.heal() }
        }
    }
    println("Игра окончена")
    characters.forEach { it.displayStatus() }
}