package CommandUnit

import Data.Percent
import InfantryUnit.InfantryUnit

interface CommandUnit : InfantryUnit {
    var commandExperience: Percent
    var commandCombatExperience: Percent

    fun commandEfficiency(): Double {
        var commandEfficiency = 0.5 // выход из строя всего командного состава уменьшит эффективность управления на половину
        if (inOrder) {
            val commandExperience = commandExperience.toDouble()
            val commandCombatExperience = commandCombatExperience.toDouble()
            commandEfficiency = (commandExperience / 100 + 0.5)     //равновесное состояние командирского опыта - 50%
            if (isBattleTried) {
                commandEfficiency += (commandCombatExperience / 100 * 2 + 0.5)  //обстрелянность командира увеличивает боеспособность подразделения сразу на 50%
            }
        }
        return commandEfficiency
    }
}
