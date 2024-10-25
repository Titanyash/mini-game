import kotlin.random.Random

class RandomGenerator {
     companion object {
        fun randomHeal(): Int {
            return Random.nextInt(5, 15)
        }
        fun randomCriticalAttack(): Int {
            return Random.nextInt(15, 25)
        }
    }
}