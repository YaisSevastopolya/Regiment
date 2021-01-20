package Events

import CommandUnit.CommandUnit
import InfantryUnit.InfantryUnit
import VehicleUnit.VehicleUnit
import kotlin.random.Random

object OneDayMore {
    fun eat(infantryUnit: InfantryUnit) {
        infantryUnit.isFed -= Random.nextInt(10,20 + 1)
    }
    fun illness(infantryUnit: InfantryUnit) {
        var x = 1
        if (infantryUnit.isAlcoholic) {
            x = 2
        }
        if (infantryUnit.isFed.toDouble() < 10.0) {
            x = 3
        }
        val chance_a = Random.nextInt(x, 4 + 1)
        val chance_b = Random.nextInt(x, 5 + 1)
        if (chance_a == chance_b) {
            infantryUnit.isIll = true
        }
    }
    fun lazy(infantryUnit: InfantryUnit) {
        infantryUnit.isTrained -= Random.nextInt(0,3 + 1)
        infantryUnit.vehicleDriverExperience -= Random.nextInt(0,2 + 1)
    }
    fun lazyCommand(commandUnit: CommandUnit) {
        commandUnit.commandExperience -= Random.nextInt(0,2 + 1)
    }
    fun alcoholism(infantryUnit: InfantryUnit) {
        val chance_a = Random.nextInt(1, 10 + 1)
        val chance_b = Random.nextInt(1, 10 + 1)
        if (chance_a == chance_b) {
            infantryUnit.isAlcoholic = true
        }
    }
    fun crime(infantryUnit: InfantryUnit) {
        var x = 1
        if (infantryUnit.isAlcoholic) {
            x = 10
        }
        val chance_a = Random.nextInt(x, 20 + 1)
        val chance_b = Random.nextInt(x, 20 + 1)
        if (chance_a == chance_b) {
            infantryUnit.isArrested = true
        }
    }
    fun malfunction(vehicleUnit: VehicleUnit) {
        val chance_a = Random.nextInt(1, 5 + 1)
        val chance_b = Random.nextInt(1, 5 + 1)
        if (chance_a == chance_b) {
            vehicleUnit.malfunction = true
        }
    }
    fun recovery(infantryUnit: InfantryUnit) {
        if (infantryUnit.isIll) {
            val chance_a = Random.nextInt(1, 2 + 1)
            val chance_b = Random.nextInt(1, 3 + 1)
            if (chance_a == chance_b) {
                infantryUnit.isIll = false
            }
        }
    }
}