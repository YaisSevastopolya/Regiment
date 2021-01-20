package CommandUnit

import InfantryUnit.InfantryUnitFun
import kotlin.random.Random

abstract class CommandUnitFun : CommandUnit, InfantryUnitFun() {
    override fun commandEfficiency(): Double {
        var commandEfficiency = 0.5 // выход из строя всего командного состава уменьшит эффективность управления на половину
        if (inOrder) {
            val commandExperience = commandExperience.toDouble()
            val commandCombatExperience = commandCombatExperience.toDouble()
            commandEfficiency = (commandExperience / 100 + 0.5)     //равновесное состояние командирского опыта - 50%
            if (isAlcoholic) {
                commandEfficiency *= (Random.nextInt(20,120 + 1) / 100)
            }
            if (isBattleTried) {
                commandEfficiency += (commandCombatExperience / 100 * 2 + 0.5)  //обстрелянность командира увеличивает боеспособность подразделения сразу на 50%
            }
        }
        return commandEfficiency
    }
}