import kotlin.random.Random

class Robot(health: Int, power: Int, attack: Int) : Human(health,health, power, attack) {
    var battery: Int = power
    override fun attack(opponent: Human) {
        val damage = if (battery > power / 2) attack * 2 else attack
        val critical = if (Random.nextInt(0,100) < 10) Random.nextInt(15, 25) else 0
        val totalDamage = damage + critical
        println("Робот атакует и наносит $totalDamage урона (критический урон: $critical)")
        opponent.recieveDamage(totalDamage)
        battery -= 10
    }
    override fun heal() {
        if (Random.nextInt(100)<30) {
            val healAmount = RandomGenerator.randomHeal()
            health = (health + healAmount).coerceAtMost(maxHealth)
            println("Робот восстанавливает $healAmount здоровья")
        }
        if (Random.nextInt(100)<30) {
            val batteryAmount = RandomGenerator.randomHeal()
            if (battery+batteryAmount<=power) {
                battery = battery + batteryAmount
                println("Робот восстанавливает $batteryAmount заряда батареи")
            }
        }
    }
    override fun isAlive() = health > 0
    override fun displayStatus() {
        println("Робот -> Здоровье: $health, Батарея: $battery")
    }
}