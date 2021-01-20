package Decisions

import InfantryUnit.InfantryUnit
import kotlin.random.Random

object Training {
    fun training(infantryUnit: InfantryUnit) {
        infantryUnit.isTrained += Random.nextInt(10, 15 + 1)
        if (infantryUnit.isTrained.toDouble() > 90.0) {
            val chance_a = Random.nextInt(1, 6 + 1)
            val chance_b = Random.nextInt(1, 6 + 1)
            if (chance_a == chance_b) {
                infantryUnit.isSportsman = true
            }
        }
    }
}