package Unit

import CommandUnit.CommandUnit
import CommandUnit.TankRegimentLeader
import InfantryUnit.*
import VehicleUnit.T_72B3
import VehicleUnit.VehicleUnit

class TankRegiment  : Unit {

    override val structureCommand = listOf<CommandUnit>(
        TankRegimentLeader(),
    )
    override val structureInfantry = listOf<InfantryUnit>(
        DriverMechanic(),
        GunnerOperator(),
    )
    override val structureVehicle = listOf<VehicleUnit>(
        T_72B3(),
    )
    override val structureUnit = listOf<Unit>(
        TankBattalion(),
        TankBattalion(),
        TankBattalion(),
        MotorizedBattalion(),
    )

    override val maxCrew = structureVehicle[0].maxCrew
    override val minCrew = structureVehicle[0].minCrew
}