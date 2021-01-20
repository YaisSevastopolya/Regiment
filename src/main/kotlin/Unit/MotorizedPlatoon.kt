package Unit

import CommandUnit.CommandUnit
import InfantryUnit.InfantryUnit
import CommandUnit.MotorizedPlatoonLeader
import VehicleUnit.VehicleUnit

class MotorizedPlatoon : MilitaryUnitFun() {
    override val structureCommand = listOf<CommandUnit>(
        MotorizedPlatoonLeader(),
    )
    override val structureInfantry = listOf<InfantryUnit>()
    override val structureVehicle = listOf<VehicleUnit>()
    override val structureMilitaryUnit = listOf<MilitaryUnit>(
        MotorizedSquad(),
        MotorizedSquad(),
        MotorizedSquad(),
    )

    override val maxCrew = 0
    override val minCrew = 0
}