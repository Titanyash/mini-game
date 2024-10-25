import Combatant
abstract class Human (
    var health: Int,
    val maxHealth:Int,
    val power: Int,
    var attack: Int
    ) : Combatant {
        abstract fun isAlive(): Boolean
        abstract fun displayStatus()
        open fun recieveDamage (damage:Int) {
            health-=damage
        }
}