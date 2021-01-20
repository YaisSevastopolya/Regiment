package InfantryUnit

import Data.Data
import Data.Percent

class SeniorRifleman (
    override val position: String = "seniorRifleman",
    override var isIll: Boolean = false,
    override var isWounded: Boolean = false,
    override var isKilled: Boolean = false,
    override var isArrested: Boolean = false,
    override var isFed: Percent = Percent(100),
    override var isArmed: Boolean = true,
    override var isEquipped: Percent = Percent(100),
    override var isTrained: Percent = Percent(50),
    override var isBattleTried: Boolean = false,
    override var combatExperience: Percent = Percent(0),
    override var vehicleDriverExperience: Percent = Percent(0),
    override var vehicleCombatDriverExperience: Percent = Percent(0),
    override var isAlcoholic: Boolean = false,
    override var isSportsman: Boolean = false,
) : InfantryUnitFun() {
    override val basicCombatPower = (Data.database["seniorRifleman"] ?: error("")).basicCombatPower
}