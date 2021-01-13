package Unit

import CommandUnit.CommandUnit
import InfantryUnit.InfantryUnit
import CommandUnit.MotorizedPlatoonLeader
import VehicleUnit.VehicleUnit

class MotorizedPlatoon : Unit {
    override val structureCommand = listOf<CommandUnit>(
        MotorizedPlatoonLeader(),
    )
    override val structureInfantry = listOf<InfantryUnit>()
    override val structureVehicle = listOf<VehicleUnit>()
    override val structureUnit = listOf<Unit>(
        MotorizedSquad(),
        MotorizedSquad(),
        MotorizedSquad(),
    )

    override val maxCrew = 0
    override val minCrew = 0
}