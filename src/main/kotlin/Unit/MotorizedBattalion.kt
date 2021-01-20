package Unit

import CommandUnit.CommandUnit
import CommandUnit.MotorizedBattalionLeader
import InfantryUnit.*
import VehicleUnit.BMP_3
import VehicleUnit.VehicleUnit

class MotorizedBattalion : MilitaryUnitFun() {
    override val structureCommand = listOf<CommandUnit>(
        MotorizedBattalionLeader(),
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
    override val structureMilitaryUnit = listOf<MilitaryUnit>(
        MotorizedCompany(),
        MotorizedCompany(),
        MotorizedCompany(),
    )

    override val maxCrew = structureVehicle[0].maxCrew
    override val minCrew = structureVehicle[0].minCrew
}
