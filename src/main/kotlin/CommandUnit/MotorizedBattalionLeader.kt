package CommandUnit

import Data.Data
import Data.Percent

class MotorizedBattalionLeader (
    override val position: String = "motorizedBattalionLeader",
    override var inOrder: Boolean = true,
    override var isFed: Percent = Percent(100),
    override var isArmed: Boolean = true,
    override var isEquipped: Percent = Percent(100),
    override var isTrained: Percent = Percent(50),
    override var isBattleTried: Boolean = false,
    override var combatExperience: Percent = Percent(0),
    override var vehicleDriverExperience: Percent = Percent(100),
    override var vehicleCombatDriverExperience: Percent = Percent(0),

    override var commandExperience: Percent = Percent(50),
    override var commandCombatExperience: Percent = Percent(0),
) : CommandUnit {
    override val basicCombatPower = (Data.database["motorizedBattalionLeader"] ?: error("")).basicCombatPower
}