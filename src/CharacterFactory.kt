
class CharacterFactory {
    companion object {
        fun createCharacter(type: String, health: Int, power: Int, attack: Int): Human {
            return when (type) {
                "wizard" -> Wizard(health, power, attack)
                "robot" -> Robot(health, power, attack)
                "knight" -> Knight(health, power, attack)
                else -> throw IllegalArgumentException("Неизвестный тип персонажа")
            }
        }
    }
}