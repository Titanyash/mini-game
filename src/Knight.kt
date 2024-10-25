import kotlin.random.Random

class Knight(health: Int, power: Int, attack: Int) : Human(health,health, power, attack) {
    var defense: Int = power
    override fun recieveDamage (damage:Int) {
        val halfDamage= damage /2
        val damagetoDef = halfDamage.coerceAtMost(defense)
        defense-=damagetoDef
        val remainDam=halfDamage-damagetoDef
        val damagetoheal=halfDamage+remainDam
        health-=damagetoheal
    }
    override fun attack(opponent: Human) {
        val damage = attack
        val critical = if (Random.nextInt(0, 100) < 10) Random.nextInt(15, 25) else 0
        val totalDamage = damage + critical
        println("Рыцарь атакует и наносит $totalDamage урона (критический урон: $critical)")
        opponent.recieveDamage(totalDamage)
    }
    override fun heal() {
        if (Random.nextInt(100)<30) {
            val healAmount = RandomGenerator.randomHeal()
            health = (health + healAmount).coerceAtMost(maxHealth)
            println("Рыцарь восстанавливает $healAmount здоровья")
        }
        if (Random.nextInt(100)<30) {
            val defenseAmount = RandomGenerator.randomHeal()
            if (defense+defenseAmount<=power) {
                defense = defense + defenseAmount
                println("Рыцарь восстанавливает $defenseAmount защиты")
            }
        }
    }
    override fun isAlive() = health > 0
    override fun displayStatus() {
        println("Рыцарь -> Здоровье: $health, Защита: $defense")
    }

}