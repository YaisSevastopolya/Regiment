package VehicleUnit

import Data.Data
import Data.Percent

class T_72B3 (
    override val position: String = "T_72B3",
    override var inOrder: Boolean = true,
    override var isArmed: Boolean = true,
    override var isEquipped: Percent = Percent(100),
    override var isFueled: Percent = Percent(100),

    override val maxCrew: Int = 3,
    override val minCrew: Int = 2,
) : VehicleUnit {
    override val basicCombatPower = (Data.database["T_72B3"] ?: error("")).basicCombatPower
}