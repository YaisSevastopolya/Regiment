package Events

import InfantryUnit.InfantryUnit

object CombatEpisode {
    fun lossesInfantry(infantryUnit: InfantryUnit) {
        infantryUnit.inOrder = false
    }
}