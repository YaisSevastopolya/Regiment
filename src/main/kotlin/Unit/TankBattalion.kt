package Unit

import CommandUnit.CommandUnit
import CommandUnit.TankBattalionLeader
import InfantryUnit.*
import VehicleUnit.T_72B3
import VehicleUnit.VehicleUnit

class TankBattalion : MilitaryUnitFun() {

    override val structureCommand = listOf<CommandUnit>(
        TankBattalionLeader(),
    )
    override val structureInfantry = listOf<InfantryUnit>(
        DriverMechanic(),
        GunnerOperator(),
    )
    override val structureVehicle = listOf<VehicleUnit>(
        T_72B3(),
    )
    override val structureMilitaryUnit = listOf<MilitaryUnit>(
        TankCompany(),
        TankCompany(),
        TankCompany(),
    )

    override val maxCrew = structureVehicle[0].maxCrew
    override val minCrew = structureVehicle[0].minCrew
}