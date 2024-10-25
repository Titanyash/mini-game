import kotlin.random.Random

class Wizard(health: Int, power: Int, attack: Int) : Human(health,health, power, attack) {
    var mana: Int = power
    override fun attack(opponent: Human) {
        val damage = if (mana > power / 2) attack * 2 else attack
        val critical = if (Random.nextInt(0,100) < 10) Random.nextInt(15, 25) else 0
        val totalDamage = damage + critical
        println("Волшебник атакует и наносит $totalDamage урона (критический урон: $critical)")
        opponent.recieveDamage(totalDamage)
        mana -= 10
    }
    override fun heal() {
        if (Random.nextInt(100)<30) {
            val healAmount = RandomGenerator.randomHeal()
            health = (health + healAmount).coerceAtMost(maxHealth)
            println("Волшебник восстанавливает $healAmount здоровья")
        }
        if (Random.nextInt(100)<30) {
            val manaAmount = RandomGenerator.randomHeal()
            if (manaAmount+mana<=power){
                mana = mana + manaAmount
                println("Волшебник восстанавливает $manaAmount маны")
            }
        }
    }
    override fun isAlive() = health > 0
    override fun displayStatus() {
        println("Волшебник -> Здоровье: $health, Мана: $mana")
    }
}