package Decisions

import Data.Percent
import InfantryUnit.InfantryUnit
import VehicleUnit.VehicleUnit

object Ammunition {
    fun ammunition(infantryUnit: InfantryUnit) {
        infantryUnit.isEquipped = Percent(100)
    }
    fun ammunition(vehicleUnit: VehicleUnit) {
        vehicleUnit.isEquipped = Percent(100)
    }
}