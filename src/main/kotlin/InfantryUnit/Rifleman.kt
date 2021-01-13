package InfantryUnit

import Data.Data
import Data.Percent

class Rifleman (
    override val position: String = "rifleman",
    override var inOrder: Boolean = true,
    override var isFed: Percent = Percent(100),
    override var isArmed: Boolean = true,
    override var isEquipped: Percent = Percent(100),
    override var isTrained: Percent = Percent(50),
    override var isBattleTried: Boolean = false,
    override var combatExperience: Percent = Percent(0),
    override var vehicleDriverExperience: Percent = Percent(0),
    override var vehicleCombatDriverExperience: Percent = Percent(0),
) : InfantryUnit {
    override val basicCombatPower = (Data.database["rifleman"] ?: error("")).basicCombatPower
}