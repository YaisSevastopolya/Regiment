package Unit

import CommandUnit.CommandUnit
import CommandUnit.TankCompanyLeader
import InfantryUnit.*
import VehicleUnit.T_72B3
import VehicleUnit.VehicleUnit

class TankCompany : MilitaryUnitFun() {
    override val structureCommand = listOf<CommandUnit>(
        TankCompanyLeader(),
    )
    override val structureInfantry = listOf<InfantryUnit>(
        DriverMechanic(),
        GunnerOperator(),
    )
    override val structureVehicle = listOf<VehicleUnit>(
        T_72B3(),
    )
    override val structureMilitaryUnit = listOf<MilitaryUnit>(
        TankPlatoon(),
        TankPlatoon(),
        TankPlatoon(),
    )

    override val maxCrew = structureVehicle[0].maxCrew
    override val minCrew = structureVehicle[0].minCrew
}