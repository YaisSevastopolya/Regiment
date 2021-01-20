package CommandUnit

import Data.Percent
import InfantryUnit.InfantryUnit

interface CommandUnit : InfantryUnit {
    var commandExperience: Percent
    var commandCombatExperience: Percent

    fun commandEfficiency(): Double
}
