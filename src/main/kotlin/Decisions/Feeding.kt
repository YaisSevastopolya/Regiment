package Decisions

import InfantryUnit.InfantryUnit
import kotlin.random.Random

object Feeding {
    fun feeding(infantryUnit: InfantryUnit) {
        infantryUnit.isFed += Random.nextInt(20, 25 + 1)
    }
}