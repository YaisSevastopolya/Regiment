package Unit

import CommandUnit.CommandUnit
import CommandUnit.MotorizedSquadLeader
import InfantryUnit.*
import VehicleUnit.VehicleUnit
import VehicleUnit.BMP_3

class MotorizedSquad : Unit {
    override val structureCommand = listOf<CommandUnit>(
        MotorizedSquadLeader(),
    )
    override val structureInfantry = listOf<InfantryUnit>(
        DriverMechanic(),
        GunnerOperator(),
        SeniorRifleman(),
        MachineGunner(),
        GrenadeLauncher(),
        GrenadeLauncherAssistant(),
        Rifleman(),
    )
    override val structureVehicle = listOf<VehicleUnit>(
        BMP_3(),
    )
    override val structureUnit = listOf<Unit>()

    override val maxCrew = structureVehicle[0].maxCrew
    override val minCrew = structureVehicle[0].minCrew
}