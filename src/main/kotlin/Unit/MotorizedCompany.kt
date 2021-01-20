package Unit

import CommandUnit.CommandUnit
import CommandUnit.DeputyCompanyLeader
import CommandUnit.MotorizedCompanyLeader
import InfantryUnit.*
import VehicleUnit.BMP_3
import VehicleUnit.VehicleUnit

class MotorizedCompany : MilitaryUnitFun() {

    override val structureCommand = listOf<CommandUnit>(
        MotorizedCompanyLeader(),
        DeputyCompanyLeader(),
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
        MotorizedPlatoon(),
        MotorizedPlatoon(),
        MotorizedPlatoon(),
    )

    override val maxCrew = structureVehicle[0].maxCrew
    override val minCrew = structureVehicle[0].minCrew
}