package Unit

import CommandUnit.CommandUnit
import CommandUnit.TankPlatoonLeader
import InfantryUnit.DriverMechanic
import InfantryUnit.GunnerOperator
import InfantryUnit.InfantryUnit
import VehicleUnit.T_72B3
import VehicleUnit.VehicleUnit

class TankPlatoon : MilitaryUnitFun() {
    override val structureCommand = listOf<CommandUnit>(
        TankPlatoonLeader(),
    )
    override val structureInfantry = listOf<InfantryUnit>(
        DriverMechanic(),
        GunnerOperator(),
    )
    override val structureVehicle = listOf<VehicleUnit>(
        T_72B3(),
    )
    override val structureMilitaryUnit = listOf<MilitaryUnit>(
        TankSquad(),
        TankSquad(),
    )

    override val maxCrew = structureVehicle[0].maxCrew
    override val minCrew = structureVehicle[0].minCrew
}