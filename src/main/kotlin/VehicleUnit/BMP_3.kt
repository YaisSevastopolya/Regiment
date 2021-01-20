package VehicleUnit

import Data.Data
import Data.Percent

class BMP_3 (
    override val position: String = "BMP_3",
    override var malfunction: Boolean = false,
    override var damage: Boolean = false,
    override var destroyed: Boolean = false,
    override var isArmed: Boolean = true,
    override var isEquipped: Percent = Percent(100),
    override var isFueled: Percent = Percent(100),

    override val maxCrew: Int = 3,
    override val minCrew: Int = 2,
) : VehicleUnitFun() {
    override val basicCombatPower = (Data.database["BMP_3"] ?: error("")).basicCombatPower
}