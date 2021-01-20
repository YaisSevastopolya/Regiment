package Events

import CommandUnit.CommandUnit
import InfantryUnit.InfantryUnit
import VehicleUnit.VehicleUnit
import kotlin.random.Random

object CombatEpisode {
    fun lossesInfantry(infantryUnit: InfantryUnit) {
        //infantryUnit.isKilled = true
        var chance_a = Random.nextInt(1, 3 + 1)
        var chance_b = Random.nextInt(1, 3 + 1)
        if (chance_a == chance_b) {
            infantryUnit.isWounded = true
        } else {
            chance_a = Random.nextInt(1, 3 + 1)
            chance_b = Random.nextInt(1, 4 + 1)
            if (chance_a == chance_b) {
                infantryUnit.isKilled = true
            }
        }
    }
    fun combatExperience(infantryUnit: InfantryUnit) {
        infantryUnit.isEquipped -= Random.nextInt(10, 20 + 1)
        infantryUnit.isBattleTried = true
        infantryUnit.combatExperience += Random.nextInt(1, 5 + 1)
        infantryUnit.vehicleCombatDriverExperience += Random.nextInt(1, 4 + 1)
    }
    fun commandCombatExperience(commandUnit: CommandUnit) {
        commandUnit.commandCombatExperience += Random.nextInt(1, 3 + 1)
    }
    fun infantryCombat(infantryUnit: InfantryUnit) {
        infantryUnit.isEquipped -= Random.nextInt(1, 50 + 1)
    }
    fun vehicleUsing(vehicleUnit: VehicleUnit) {
        vehicleUnit.isEquipped -= Random.nextInt(1, 50 + 1)
        vehicleUnit.isFueled -= Random.nextInt(10, 20 + 1)
    }
    fun vehicleDamage(vehicleUnit: VehicleUnit) {
        var chance_a = Random.nextInt(1, 3 + 1)
        var chance_b = Random.nextInt(1, 3 + 1)
        if (chance_a == chance_b) {
            vehicleUnit.damage = true
        } else {
            chance_a = Random.nextInt(1, 3 + 1)
            chance_b = Random.nextInt(1, 4 + 1)
            if (chance_a == chance_b) {
                vehicleUnit.destroyed = true
            }
        }
    }
}